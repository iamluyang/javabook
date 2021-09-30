package online.javabook.flink.demo.order.window.count;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.domain.OrderOutput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.aggregate.OrderInputPriceAggregateFunction;
import online.javabook.flink.framework.window.function.process.OrderInputProcessCountWindowFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceSumReduceFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Keyed Windows
 * <p>
 * stream
 * .keyBy(...)               <-  keyed versus non-keyed windows
 * .window(...)              <-  required: "assigner"
 * [.trigger(...)]            <-  optional: "trigger" (else default trigger)
 * [.evictor(...)]            <-  optional: "evictor" (else no evictor)
 * [.allowedLateness(...)]    <-  optional: "lateness" (else zero)
 * [.sideOutputLateData(...)] <-  optional: "output tag" (else no side output for late data)
 * .reduce/aggregate/apply()      <-  required: "function"
 * [.getSideOutput(...)]      <-  optional: "output tag"
 * <p>
 * ---------------------------------------------------------------
 * <p>
 * Non-Keyed Windows
 * <p>
 * stream
 * .windowAll(...)           <-  required: "assigner"
 * [.trigger(...)]            <-  optional: "trigger" (else default trigger)
 * [.evictor(...)]            <-  optional: "evictor" (else no evictor)
 * [.allowedLateness(...)]    <-  optional: "lateness" (else zero)
 * [.sideOutputLateData(...)] <-  optional: "output tag" (else no side output for late data)
 * .reduce/aggregate/apply()      <-  required: "function"
 * [.getSideOutput(...)]      <-  optional: "output tag"
 */
public class OrderSimpleStreamSetWithTumblingCountWindow {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // source
        DataStream<String> stream = env.addSource(new OrderSimpleStreamSetWithTumblingCountWindowSource());

        // transform
        // count window - 2
        // ------------------------------->
        // | 10,9 | 8,7 | 6,5 | 4,3 | 2,1 |
        //                          | --3 |
        //                    | --7 |
        //              | --11|
        //         |--15|
        // |   --19|

        // OrderPriceSumReduceFunction
        DataStream<OrderInput> input1 = stream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A", "B"))
                .keyBy(new OrderInputKeySelectorFunction())
                .countWindow(2)
                .reduce(new OrderInputPriceSumReduceFunction());
        //input1.print();

        // OrderPriceAggregateFunction
        SingleOutputStreamOperator<OrderOutput> input2 = stream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A", "B"))
                .keyBy(new OrderInputKeySelectorFunction())
                .countWindow(2)
                .aggregate(new OrderInputPriceAggregateFunction());
        //input2.print();

        // OrderPriceSumProcessWindowFunction
        SingleOutputStreamOperator<OrderOutput> input3 = stream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A"))
                .keyBy(new OrderInputKeySelectorFunction())
                .countWindow(2)
                .process(new OrderInputProcessCountWindowFunction());
        input3.print();

        // execute
        env.execute();
    }
}