package online.javabook.jvm.thread.samethread;

import java.util.concurrent.*;

public class MultiThreadConcurrencyMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.printf("%20s%20s%20s\n", "Tasks", "Threads", "Time(Mill)");

        int maxTasks = 10000 * 10000;
        int maxThreads = Runtime.getRuntime().availableProcessors();

        for (int minThreads = 1; minThreads <= maxThreads; ) {
            ExecutorService executorService = Executors.newFixedThreadPool(maxThreads);
            long start = System.currentTimeMillis();
            for (int j = 0; j < maxTasks; j++){
                executorService.execute(new QuickTask());
            }

            executorService.shutdown();
            //executorService.awaitTermination(30, TimeUnit.SECONDS);

            long finish = System.currentTimeMillis();
            System.out.printf("%20s%20s%20s\n", maxTasks, minThreads, finish - start);

            minThreads = minThreads * 2;
        }
    }
}
