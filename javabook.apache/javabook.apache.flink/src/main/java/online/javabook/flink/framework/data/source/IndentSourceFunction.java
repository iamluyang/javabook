package online.javabook.flink.framework.data.source;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class IndentSourceFunction implements SourceFunction<String> {

    private AtomicLong numberA = new AtomicLong();
    private AtomicLong numberB = new AtomicLong();
    private AtomicLong numberC = new AtomicLong();

    private static Random random = new Random();
    private String names[] = {"A-I", "B-I", "C-I"};
    private boolean running = true;

    @Override
    public void run(SourceContext<String> sourceContext) throws Exception {

        while (running) {
            String name = names[random.nextInt(names.length)];
            long count = 0;
            if(name.equals("A-I")) {
                count = numberA.incrementAndGet();
            } else if(name.equals("B-I")) {
                count = numberB.incrementAndGet();
            } else if(name.equals("C-I")) {
                count = numberC.incrementAndGet();
            }

            String location = name+"-L-"+count;
            sourceContext.collect(name + " "+ location + " " + count);
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {

        this.running = false;
    }
}
