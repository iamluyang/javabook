package online.javabook.flink.framework.operators.keyby;

import online.javabook.flink.framework.data.domain.OrderInput;
import org.apache.flink.api.java.functions.KeySelector;

public class OrderInputKeySelectorFunction implements KeySelector<OrderInput, String> {
    @Override
    public String getKey(OrderInput order) {
        return order.getName();
    }
}
