package online.javabook.jvm.thread.samethread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiSingleThreadLoopMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.printf("%20s%20s%20s\n", "Tasks", "Threads", "Time(Mill)");
        int maxTasks = 10000 * 10000;
        int maxThreads = Runtime.getRuntime().availableProcessors();
        for (int minThreads = 1; minThreads <= maxThreads; ) {

            CountDownLatch startCountDown = new CountDownLatch(minThreads);
            CountDownLatch finishCountDown = new CountDownLatch(minThreads);
            int tasksPreThread = maxTasks / minThreads;

            Runnable runnable = new Runnable() {

                private int tasks = tasksPreThread;

                @Override
                public void run() {
                    startCountDown.countDown();
                    for (int j = 0; j < tasks; j++) {
                        new QuickTask().run();
                    }
                    finishCountDown.countDown();
                }
            };

            for (int j = 0; j < minThreads; j++) {
                new Thread(runnable).start();
            }

            startCountDown.await();
            long start = System.currentTimeMillis();

            finishCountDown.await();
            long finish = System.currentTimeMillis();

            System.out.printf("%20s%20s%20s\n", maxTasks, minThreads, finish - start);
            minThreads = minThreads * 2;
        }
    }
}
