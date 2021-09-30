package online.javabook.flink.demo.order.window.time;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceSumReduceFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

public class OrderSimpleStreamSetWithProcessingTimeSlidingWindow {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // source
        DataStream<String> inputDataStream = env.addSource(new OrderSimpleStreamSetWithProcessingTimeSlidingWindowSource());

        // transform
        // Sliding processing time windows - 4,2
        // ------------------------------->
        // | 10,9 | 8,7 | 6,5 | 4,3 | 2,1 |
        //                          | 3   |
        //                    |10---------|
        //              |18---------|
        //        |26---------|
        // |34 ---------|
        DataStream<OrderInput> transformDataStream = inputDataStream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A"))
                .keyBy(new OrderInputKeySelectorFunction())
                .window(SlidingProcessingTimeWindows.of(Time.seconds(10), Time.seconds(5)))
                .reduce(new OrderInputPriceSumReduceFunction());

        // sink
        transformDataStream.print();
        //transformDataStream.addSink(new OrderRichSinkFunction());

        // execute
        env.execute();
    }
}