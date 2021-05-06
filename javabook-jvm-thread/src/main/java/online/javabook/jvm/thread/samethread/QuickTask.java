package online.javabook.jvm.thread.samethread;

import java.util.Random;

public class QuickTask implements Runnable {

    private static Random random = new Random();
    @Override
    public void run() {
        double a = random.nextDouble();
        double b = random.nextDouble();
        double c = a * b;
    }
}
