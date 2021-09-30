package online.javabook.flink.framework.window.function.process;

import online.javabook.flink.framework.data.domain.OrderInput;
import online.javabook.flink.framework.data.domain.OrderOutput;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * Process窗口函数会缓冲元素，不会增量聚合，直到窗口被认为准备好进行处理
 */
public class OrderInputProcessTimeWindowFunction extends ProcessWindowFunction<OrderInput, OrderOutput, String, TimeWindow> {

    @Override
    public void process(String key, Context context, Iterable<OrderInput> input, Collector<OrderOutput> output) throws Exception {
        System.out.println(context.window().hashCode()+":"+ format(context.window().getStart()) + "<->" + format(context.window().getEnd()));
        for (OrderInput orderInput : input) {
            System.out.println("+"+orderInput);
        }
        OrderOutput result = processResult(key, input);
        output.collect(result);
    }

    private OrderOutput processResult(String key, Iterable<OrderInput> input) {

        OrderOutput result = new OrderOutput();
        result.setName(key);
        for (OrderInput order : input) {
            result.setTotal(result.getTotal() + order.getPrice());
            result.setCount(result.getCount() + 1);
        }
        result.setAverage(result.getTotal() / result.getCount());
        return result;
    }

    private String format(long timestamp) {
        return DateFormatUtils.format(timestamp, "yy-mm-dd:hh-mm-ss");
    }
}
