package online.javabook.flink.demo.order.window.time;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceSumReduceFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

public class OrderSimpleStreamSetWithProcessingTimeTumblingWindow {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        // stream
        DataStream<String> stream = env.addSource(new OrderSimpleStreamSetWithProcessingTimeTumblingWindowSource());

        // transform
        // Tumbling Processing time windows - 10
        // --------------------------------------------->
        // 16,15,14,13 | 12,11,10,9 | 8,7,6,5 | 4,3,2,1 |
        // |     -- 58 |       --42 |    --26 |    --10 |
        SingleOutputStreamOperator<OrderInput> input = stream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A"))
                .keyBy(new OrderInputKeySelectorFunction())
                .window(TumblingProcessingTimeWindows.of(Time.seconds(10)))
                .reduce(new OrderInputPriceSumReduceFunction());

        // output
        input.print();

        // execute
        env.execute();
    }
}