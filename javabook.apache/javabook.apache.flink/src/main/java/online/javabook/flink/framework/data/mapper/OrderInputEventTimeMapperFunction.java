package online.javabook.flink.framework.data.mapper;

import online.javabook.flink.framework.data.domain.OrderInput;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.util.Collector;

public class OrderInputEventTimeMapperFunction extends RichFlatMapFunction<String, OrderInput> {
    public void flatMap(String value, Collector<OrderInput> out) {
        String[] values = value.split(" ");
        out.collect(new OrderInput(values[0], values[1], Integer.parseInt(values[2]), values[3]));
    }
}