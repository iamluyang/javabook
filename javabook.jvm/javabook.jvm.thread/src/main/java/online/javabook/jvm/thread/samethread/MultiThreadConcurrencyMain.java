package online.javabook.jvm.thread.samethread;

import java.util.concurrent.*;

public class MultiThreadConcurrencyMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.printf("%20s%20s%20s%20s\n", "Tasks", "Threads", "Time(Mill)", "Count");

        int maxTasks = 10000 * 1000;
        int maxThreads = Runtime.getRuntime().availableProcessors();

        for (int minThreads = 1; minThreads <= maxThreads; ) {
            ExecutorService executorService = Executors.newFixedThreadPool(maxThreads);
            long start = System.currentTimeMillis();
            for (int j = 0; j < maxTasks; j++){
                executorService.execute(new QuickTask());
            }

            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

            long finish = System.currentTimeMillis();
            System.out.printf("%20s%20s%20s%20s\n", maxTasks, minThreads, finish - start, QuickTask.integer.get());

            minThreads = minThreads * 2;
            QuickTask.integer.set(0);
        }
    }
}
