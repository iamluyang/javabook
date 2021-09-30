package online.javabook.flink.demo.order.window.time;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class OrderSimpleStreamSetWithEventTimeTumblingWindowSource implements SourceFunction<String> {

    private AtomicLong numberA = new AtomicLong();
    private AtomicLong numberB = new AtomicLong();
    private AtomicLong numberC = new AtomicLong();

    private static Random random = new Random();
    private String names[] = {"A"/*, "B", "C"*/};

    @Override
    public void run(SourceContext<String> sourceContext) throws Exception {
        String name = names[random.nextInt(names.length)];
        long count = 0;
        if (name.equals("A")) {
            count = numberA.incrementAndGet();
        } else if (name.equals("B")) {
            count = numberB.incrementAndGet();
        } else if (name.equals("C")) {
            count = numberC.incrementAndGet();
        }

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int hour = 1;
        int mins = 1;
        int secs = 1;

        while (true) {
            sourceContext.collect(data(name, count, 1, year, month, day, hour, mins, secs));
            Thread.sleep(2000);
            secs++;
        }
    }

    private String data(String name, long count, long price, int year, int month, int day, int hrs, int min, int sec) {
        String location = "location-"+ count;
        String date = String.join("-", year+"", month+"", day+"", hrs+"" , min+"", sec+"");
        String data = name + " " + location + " " + price + " " + date;
        return data;
    }

    @Override
    public void cancel() {
    }
}
