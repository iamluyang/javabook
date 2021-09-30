package online.javabook.jvm.thread.samethread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class QuickTask implements Runnable {

    public static AtomicInteger integer = new AtomicInteger();

    private static Random random = new Random();
    @Override
    public void run() {
//        double a = random.nextDouble();
//        double b = random.nextDouble();
//        double c = a * b;
        integer.incrementAndGet();
    }
}
