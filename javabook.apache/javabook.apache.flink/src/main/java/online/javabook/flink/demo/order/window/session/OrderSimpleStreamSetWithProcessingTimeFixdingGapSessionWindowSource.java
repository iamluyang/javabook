package online.javabook.flink.demo.order.window.session;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class OrderSimpleStreamSetWithProcessingTimeFixdingGapSessionWindowSource implements SourceFunction<String> {

    private AtomicLong numberA = new AtomicLong();
    private AtomicLong numberB = new AtomicLong();
    private AtomicLong numberC = new AtomicLong();

    private static Random random = new Random();
    private String names[] = {"A"/*, "B", "C"*/};
    private boolean running = true;

    @Override
    public void run(SourceContext<String> sourceContext) throws Exception {

        while (running) {
            String name = names[random.nextInt(names.length)];
            long count = 0;
            if (name.equals("A")) {
                count = numberA.incrementAndGet();
            } else if (name.equals("B")) {
                count = numberB.incrementAndGet();
            } else if (name.equals("C")) {
                count = numberC.incrementAndGet();
            }

            if (count % 4 == 1) {
                Thread.sleep(10000);
                sourceContext.collect(data(name, count, count));
            } else {
                sourceContext.collect(data(name, count, count));
                Thread.sleep(1000);
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
