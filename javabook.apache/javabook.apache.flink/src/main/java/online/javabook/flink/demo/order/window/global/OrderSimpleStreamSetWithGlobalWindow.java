package online.javabook.flink.demo.order.window.global;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceSumReduceFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.GlobalWindows;

public class OrderSimpleStreamSetWithGlobalWindow {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // stream
        DataStream<String> stream = env.addSource(new OrderSimpleStreamSetWithGlobalWindowSource());

        // input
        DataStream<OrderInput> input = stream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A"))
                .keyBy(new OrderInputKeySelectorFunction())
                .window(GlobalWindows.create())
                .reduce(new OrderInputPriceSumReduceFunction());

        // output
        input.print();

        // execute
        env.execute();
    }
}