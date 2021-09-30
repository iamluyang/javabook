package online.javabook.flink.demo.order.window.time;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputEventTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceMaxReduceFunction;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.OutputTag;

public class OrderSimpleStreamSetWithEventTimeSlidingWindow {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        // stream
        DataStream<String> stream = env.addSource(new OrderSimpleStreamSetWithEventTimeSlidingWindowSource());

        // transform
        // time window - 10,5,5
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
                .window(SlidingEventTimeWindows.of(Time.seconds(10), Time.seconds(5)))
                .reduce(new OrderInputPriceMaxReduceFunction());

        // output
        input.print();

        // execute
        env.execute();
    }
}