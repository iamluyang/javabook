package online.javabook.flink.framework.operators.filter;

import online.javabook.flink.framework.data.domain.OrderInput;
import org.apache.flink.api.common.functions.RichFilterFunction;

public class OrderInputFilterFunction extends RichFilterFunction<OrderInput> {

    private String[] filters;

    public OrderInputFilterFunction(String... filters) {
        this.filters = filters;
    }

    @Override
    public boolean filter(OrderInput order) {
        for (String filter : filters) {
            if(order.getName().startsWith(filter)) {
                return true;
            }
        }
        return false;
    }
}
