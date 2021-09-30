package online.javabook.flink.demo.order;

import online.javabook.flink.demo.order.window.count.OrderSimpleStreamSetWithTumblingCountWindowSource;
import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.window.function.process.OrderInputKeyOutputTagProcessFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
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
public class OrderSplitStreamSet {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // source stream
        DataStream<String> inputDataStream = env.addSource(new OrderSimpleStreamSetWithTumblingCountWindowSource());

        // split stream
        SingleOutputStreamOperator<OrderInput> outputDataStream = inputDataStream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A"))
                .process(new OrderInputKeyOutputTagProcessFunction());

        // select stream
        DataStream<OrderInput> aSideOutput = outputDataStream.getSideOutput(OrderInputKeyOutputTagProcessFunction.AOutputTag);
        DataStream<OrderInput> bSideOutput = outputDataStream.getSideOutput(OrderInputKeyOutputTagProcessFunction.BOutputTag);
        DataStream<OrderInput> cSideOutput = outputDataStream.getSideOutput(OrderInputKeyOutputTagProcessFunction.COutputTag);

        // sink stream
        aSideOutput.print();

        // execute
        env.execute();
    }
}
