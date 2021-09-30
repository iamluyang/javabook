package online.javabook.flink.demo.order.window.session;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceSumReduceFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.ProcessingTimeSessionWindows;

public class OrderSimpleStreamSetWithProcessingTimeDynamicGapSessionWindow {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        // stream
        DataStream<String> stream = env.addSource(new OrderSimpleStreamSetWithProcessingTimeDynamicGapSessionWindowSource());

        // transform
        // session dynamic gap time window - 5
        // --------------------------------------------->
        // 16,15,14,13 | 12,11,10,9 | 8,7,6,5 | 4,3,2,1 |
        // |     -- 58 |       --42 |    --26 |    --10 |
        DataStream<OrderInput> input = stream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A"))
                .keyBy(new OrderInputKeySelectorFunction())
                .window(ProcessingTimeSessionWindows.withDynamicGap((element) -> {
                    // determine and return session gap
                    return 5000;
                }))
                .reduce(new OrderInputPriceSumReduceFunction());

        // output
        input.print();

        // execute
        env.execute();
    }
}