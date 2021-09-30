package online.javabook.flink.demo.order;

import online.javabook.flink.demo.order.window.count.OrderSimpleStreamSetWithTumblingCountWindowSource;
import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceMaxReduceFunction;
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
public class OrderSimpleStreamSet {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // source
        DataStream<String> inputDataStream = env.addSource(new OrderSimpleStreamSetWithTumblingCountWindowSource());

        // transform
        DataStream<OrderInput> transformDataStream = inputDataStream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .setParallelism(3)
                .filter(new OrderInputFilterFunction("A"))
                .setParallelism(1)
                .keyBy(new OrderInputKeySelectorFunction())
                .reduce(new OrderInputPriceMaxReduceFunction())
                .setParallelism(1);

        // sink
        transformDataStream.print();
        //transformDataStream.addSink(new OrderRichSinkFunction());

        // execute
        env.execute();
    }
}