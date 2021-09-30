package online.javabook.flink.demo.order.window.session;

import online.javabook.flink.demo.order.window.time.MyBoundedOutOfOrdernessTimestampExtractor;
import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceSumReduceFunction;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

public class OrderSimpleStreamSetWithEventTimeFixdingGapSessionWindow {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        // stream
        DataStream<String> stream = env.addSource(new OrderSimpleStreamSetWithEventTimeFixdingGapSessionWindowSource());

        // transform
        // EventTime SessionWindows - 5
        // --------------------------------------------->
        // 16,15,14,13 | 12,11,10,9 | 8,7,6,5 | 4,3,2,1 |
        // |     -- 58 |       --42 |    --26 |    --10 |
        DataStream<OrderInput> input = stream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A"))
                .assignTimestampsAndWatermarks(new MyBoundedOutOfOrdernessTimestampExtractor<OrderInput>(Time.seconds(0)) {
                    @Override
                    public long extractTimestamp(OrderInput element) {
                        return element.getTimestamp();
                    }
                })
                .keyBy(new OrderInputKeySelectorFunction())
                .window(EventTimeSessionWindows.withGap(Time.seconds(5)))
                .reduce(new OrderInputPriceSumReduceFunction());

        // output
        input.print();

        // execute
        env.execute();
    }
}