package online.javabook.flink.framework.window.function.reduce;

import online.javabook.flink.framework.data.domain.OrderInput;
import org.apache.flink.api.common.functions.ReduceFunction;

public class OrderInputPriceMaxReduceFunction implements ReduceFunction<OrderInput> {
    @Override
    public OrderInput reduce(OrderInput value1, OrderInput value2) throws Exception {
        if (value2.getPrice() > value1.getPrice()) {
            return new OrderInput(value2.getName(), value2.getLocation(), value2.getPrice(), value2.getTimestamp());
        } else {
            return new OrderInput(value1.getName(), value1.getLocation(), value1.getPrice(), value1.getTimestamp());
        }
    }
}
