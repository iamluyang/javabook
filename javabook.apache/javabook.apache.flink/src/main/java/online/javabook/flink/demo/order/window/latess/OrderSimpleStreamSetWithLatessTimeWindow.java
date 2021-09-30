package online.javabook.flink.demo.order.window.latess;

import online.javabook.flink.demo.order.window.time.MyBoundedOutOfOrdernessTimestampExtractor;
import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputEventTimeMapperFunction;
import online.javabook.flink.framework.data.target.OrderLateSinkFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceMaxReduceFunction;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.OutputTag;

public class OrderSimpleStreamSetWithLatessTimeWindow {

    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        // stream
        DataStream<String> stream = env.addSource(new OrderSimpleStreamSetWithLatessTimeWindowSource());


        OutputTag<OrderInput> outputTag = new OutputTag<OrderInput>("a-output-tag") {
        };

        // transform
        // time window - 10
        // 0s                             10s                          20s
        // |------------------------------|-----------------------------|
        // | 0, 1, 2, 3, 4, 5, 6, 7, 8 , 9|10,11,12,13,14,15,16,17,18,19|
        SingleOutputStreamOperator<OrderInput> input = stream
                .flatMap(new OrderInputEventTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A"))
                .assignTimestampsAndWatermarks(new MyBoundedOutOfOrdernessTimestampExtractor<OrderInput>(Time.seconds(5)) {
                    @Override
                    public long extractTimestamp(OrderInput element) {
                        return element.getTimestamp();
                    }
                })
                .keyBy(new OrderInputKeySelectorFunction())
                .window(TumblingEventTimeWindows.of(Time.seconds(10)))
                .allowedLateness(Time.seconds(5))
                .sideOutputLateData(outputTag)
                .reduce(new OrderInputPriceMaxReduceFunction());

        DataStream<OrderInput> lateness = input.getSideOutput(outputTag);

        // output
        input.print();

        // output
        lateness.addSink(new OrderLateSinkFunction());

        // execute
        env.execute();
    }
}