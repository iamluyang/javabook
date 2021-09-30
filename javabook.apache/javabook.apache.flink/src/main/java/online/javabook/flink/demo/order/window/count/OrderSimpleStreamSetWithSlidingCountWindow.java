package online.javabook.flink.demo.order.window.count;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceSumReduceFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Keyed Windows
 *
 * stream
 *        .keyBy(...)               <-  keyed versus non-keyed windows
 *        .window(...)              <-  required: "assigner"
 *       [.trigger(...)]            <-  optional: "trigger" (else default trigger)
 *       [.evictor(...)]            <-  optional: "evictor" (else no evictor)
 *       [.allowedLateness(...)]    <-  optional: "lateness" (else zero)
 *       [.sideOutputLateData(...)] <-  optional: "output tag" (else no side output for late data)
 *        .reduce/aggregate/apply()      <-  required: "function"
 *       [.getSideOutput(...)]      <-  optional: "output tag"
 *
 * ---------------------------------------------------------------
 *
 * Non-Keyed Windows
 *
 * stream
 *        .windowAll(...)           <-  required: "assigner"
 *       [.trigger(...)]            <-  optional: "trigger" (else default trigger)
 *       [.evictor(...)]            <-  optional: "evictor" (else no evictor)
 *       [.allowedLateness(...)]    <-  optional: "lateness" (else zero)
 *       [.sideOutputLateData(...)] <-  optional: "output tag" (else no side output for late data)
 *        .reduce/aggregate/apply()      <-  required: "function"
 *       [.getSideOutput(...)]      <-  optional: "output tag"
 */
public class OrderSimpleStreamSetWithSlidingCountWindow {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // stream
        DataStream<String> stream = env.addSource(new OrderSimpleStreamSetWithSlidingCountWindowSource());

        // transform
        // count window - 4,2
        // ------------------------------->
        // | 10,9 | 8,7 | 6,5 | 4,3 | 2,1 |
        //                          | 3   |
        //                    |10---------|
        //              |18---------|
        //        |26---------|
        // |34 ---------|
        DataStream<OrderInput> input = stream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A", "B"))
                .keyBy(new OrderInputKeySelectorFunction())
                .countWindow(4 ,2)
                .reduce(new OrderInputPriceSumReduceFunction());

        // output
        input.print();

        // execute
        env.execute();
    }
}