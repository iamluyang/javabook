package online.javabook.flink.framework.window.function.process;

import online.javabook.flink.framework.data.domain.OrderInput;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

public class OrderInputKeyOutputTagProcessFunction extends ProcessFunction<OrderInput, OrderInput> {

    public static OutputTag<OrderInput> AOutputTag = new OutputTag<OrderInput>("a-output-tag"){};
    public static OutputTag<OrderInput> BOutputTag = new OutputTag<OrderInput>("b-output-tag"){};
    public static OutputTag<OrderInput> COutputTag = new OutputTag<OrderInput>("c-output-tag"){};

    @Override
    public void processElement(OrderInput order, Context context, Collector<OrderInput> collector) throws Exception {
        if(order.getName().startsWith("A")) {
            context.output(AOutputTag, order);

        } else if(order.getName().startsWith("B")) {
            context.output(BOutputTag, order);

        } else if(order.getName().startsWith("C")) {
            context.output(COutputTag, order);
        }
    }
}
