package online.javabook.flink.demo.order.window.time;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class OrderSimpleStreamSetWithProcessingTimeTumblingWindowSource implements SourceFunction<String> {

    private AtomicLong numberA = new AtomicLong();

    private static Random random = new Random();
    private String names[] = {"A"};
    private boolean running = true;

    @Override
    public void run(SourceContext<String> sourceContext) throws Exception {

        while (running) {
            String name = names[random.nextInt(names.length)];
            long count = 0;
            if (name.equals("A")) {
                count = numberA.incrementAndGet();
            }

            sourceContext.collect(data(name, count, count));
            if(count % 4 ==0) {
                Thread.sleep(10000);
            }
        }
    }

    private String data(String name, long count, long price) {
        String location = "location-" + count;
        String data = name + " " + location + " " + price;
        return data;
    }

    @Override
    public void cancel() {

        this.running = false;
    }
}
