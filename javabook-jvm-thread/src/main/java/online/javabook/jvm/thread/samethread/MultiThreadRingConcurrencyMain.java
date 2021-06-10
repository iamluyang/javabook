package online.javabook.jvm.thread.samethread;

import com.nanosai.threadops.ringbuffer.RingBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiThreadRingConcurrencyMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.printf("%20s%20s%20s%20s\n", "Tasks", "Threads", "Time(Mill)", "Count");

        int maxTasks = 10 * 1;
        int maxThreads = Runtime.getRuntime().availableProcessors();

        for (int minThreads = 1; minThreads <= maxThreads; ) {
            ExecutorService executorService = new ThreadPoolExecutor(minThreads, minThreads, 0, TimeUnit.SECONDS, new RingBlockingQueue(10));
            long start = System.currentTimeMillis();
            for (int j = 0; j < maxTasks; j++){
                executorService.execute(new QuickTask());
            }

            executorService.shutdown();
            executorService.awaitTermination(30, TimeUnit.SECONDS);

            long finish = System.currentTimeMillis();
            System.out.printf("%20s%20s%20s%20s\n", maxTasks, minThreads, finish - start, QuickTask.integer.get());

            minThreads = minThreads * 2;
            QuickTask.integer.set(0);
        }
    }
}
