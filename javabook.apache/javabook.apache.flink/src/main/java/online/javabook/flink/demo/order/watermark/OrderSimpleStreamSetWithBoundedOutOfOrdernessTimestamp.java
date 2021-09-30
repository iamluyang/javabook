package online.javabook.flink.demo.order.watermark;

import online.javabook.flink.demo.order.window.count.OrderSimpleStreamSetWithTumblingCountWindowSource;
import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.mapper.OrderInputProcessTimeMapperFunction;
import online.javabook.flink.framework.operators.filter.OrderInputFilterFunction;
import online.javabook.flink.framework.operators.keyby.OrderInputKeySelectorFunction;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.windowing.time.Time;

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
public class OrderSimpleStreamSetWithBoundedOutOfOrdernessTimestamp {
    public static void main(String[] args) throws Exception {

        // env
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        // source
        DataStream<String> inputDataStream = env.addSource(new OrderSimpleStreamSetWithTumblingCountWindowSource());

        // transform
        SingleOutputStreamOperator<OrderInput> transformDataStream = inputDataStream
                .flatMap(new OrderInputProcessTimeMapperFunction())
                .filter(new OrderInputFilterFunction("A"))
                .keyBy(new OrderInputKeySelectorFunction())
                .assignTimestampsAndWatermarks(new BoundedOutOfOrdernessTimestampExtractor<OrderInput>(Time.seconds(5)) {
                    @Override
                    public long extractTimestamp(OrderInput element) {
                        return element.getTimestamp();
                    }
                });

        // sink
        transformDataStream.print();
        //transformDataStream.addSink(new OrderRichSinkFunction());

        // execute
        env.execute();
    }
}