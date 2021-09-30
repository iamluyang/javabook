package online.javabook.flink.framework.window.function.aggregate;

import online.javabook.flink.framework.data.domain.OrderAccumulator;
import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.domain.OrderOutput;
import org.apache.flink.api.common.functions.AggregateFunction;

public class OrderInputPriceAggregateFunction implements AggregateFunction<OrderInput, OrderAccumulator, OrderOutput> {

    @Override
    public OrderAccumulator createAccumulator() {
        return new OrderAccumulator();
    }

    @Override
    public OrderAccumulator add(OrderInput value, OrderAccumulator accumulator) {
        OrderAccumulator newAccumulator = new OrderAccumulator();
        newAccumulator.setName(value.getName());
        newAccumulator.setTotal(accumulator.getTotal() + value.getPrice());
        newAccumulator.setCount(accumulator.getCount()+1);
        return newAccumulator;
    }

    @Override
    public OrderOutput getResult(OrderAccumulator accumulator) {
        OrderOutput output = new OrderOutput();
        output.setName(accumulator.getName());
        output.setTotal(accumulator.getTotal());
        output.setCount(accumulator.getCount());
        output.setAverage(accumulator.getTotal() / accumulator.getCount());
        return output;
    }

    @Override
    public OrderAccumulator merge(OrderAccumulator a, OrderAccumulator b) {
        OrderAccumulator merge = new OrderAccumulator();
        merge.setName(a.getName()+"-Merge:"+"a.getTotal():"+a.getTotal()+";b.getTotal():"+b.getTotal());
        merge.setTotal(a.getTotal() + b.getTotal());
        merge.setCount(a.getCount() + b.getCount());
        return merge;
    }

}
