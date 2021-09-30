package online.javabook.flink.demo.order;

import online.javabook.flink.demo.order.window.count.OrderSimpleStreamSetWithTumblingCountWindowSource;
import online.javabook.flink.framework.data.domain.IndentInput;
import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.IndentInputProcessTimeMapperFunction;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.data.source.IndentSourceFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import online.javabook.flink.framework.window.function.reduce.OrderInputPriceMaxReduceFunction;
import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.CoMapFunction;

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
public class OrderConnectStreamSet {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        // source
        DataStream<String> orderInputDataStream = env.addSource(new OrderSimpleStreamSetWithTumblingCountWindowSource());
        DataStream<String> indentInputDataStream = env.addSource(new IndentSourceFunction());

        // order:transform
        SingleOutputStreamOperator<OrderInput> orderOutputDataStream = orderInputDataStream
                .flatMap(new OrderInputProcessTimeMapperFunction());

        // indent:transform
        SingleOutputStreamOperator<IndentInput> indentOutputDataStream = indentInputDataStream
                .flatMap(new IndentInputProcessTimeMapperFunction());

        // connect = orderOutputDataStream + indentOutputDataStream
        ConnectedStreams<OrderInput, IndentInput> connectDataStreams = orderOutputDataStream.connect(indentOutputDataStream);

        // transform
        SingleOutputStreamOperator<OrderInput> recordDataStreams = connectDataStreams
                .map(new CoMapFunction<OrderInput, IndentInput, OrderInput>() {
                    @Override
                    public OrderInput map1(OrderInput order) {
                        return new OrderInput(order.getName(), order.getLocation(), order.getPrice(), order.getTimestamp());
                    }

                    @Override
                    public OrderInput map2(IndentInput indent) {
                        return new OrderInput(indent.getName(), indent.getLocation(), indent.getPrice(), indent.getTimestamp().getTime());
                    }
                })
                .keyBy(new OrderInputKeySelectorFunction())
                .reduce(new OrderInputPriceMaxReduceFunction());

        // print
        recordDataStreams.print();

        // execute
        env.execute();
    }
}
