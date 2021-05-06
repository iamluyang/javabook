package online.javabook.jvm.thread.samethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadConcurrencyMain {
    public static void main(String[] args) throws InterruptedException {

        int threadCount = 8;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i <= 8; i++) {
            int total = (int) Math.pow(10, i);
            long start = System.currentTimeMillis();
            for (int j = 0; j < total; j++){
                executorService.execute(new MediumTask());
            }

            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

            long finish = System.currentTimeMillis();
            System.out.println("MultiThreadConcurrencyMain -> 运行 MediumTask " + total + "次，花费时间: " + (finish - start) + " milliseconds");

            executorService = Executors.newFixedThreadPool(threadCount);
        }
    }
}
