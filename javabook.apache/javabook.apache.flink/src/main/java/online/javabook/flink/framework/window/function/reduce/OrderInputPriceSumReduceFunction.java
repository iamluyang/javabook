package online.javabook.flink.framework.window.function.reduce;

import online.javabook.flink.framework.data.domain.OrderInput;
import org.apache.flink.api.common.functions.ReduceFunction;

public class OrderInputPriceSumReduceFunction implements ReduceFunction<OrderInput> {
    @Override
    public OrderInput reduce(OrderInput value1, OrderInput value2) throws Exception {
        return new OrderInput(value2.getName(), "*", value1.getPrice() + value2.getPrice(), value2.getTimestamp());
    }
}
