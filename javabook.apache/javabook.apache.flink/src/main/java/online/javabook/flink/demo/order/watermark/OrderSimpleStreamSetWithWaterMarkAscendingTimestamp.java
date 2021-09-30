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
import org.apache.flink.streaming.api.functions.timestamps.AscendingTimestampExtractor;

public class OrderSimpleStreamSetWithWaterMarkAscendingTimestamp {

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
                .assignTimestampsAndWatermarks(new AscendingTimestampExtractor<OrderInput>() {
                    public long extractAscendingTimestamp(OrderInput element) {
                        return element.getTimestamp();
                    }
                });

        // sink
        transformDataStream.print();

        // execute
        env.execute();
    }
}