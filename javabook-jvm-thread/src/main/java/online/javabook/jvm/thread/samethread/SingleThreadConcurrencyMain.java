package online.javabook.jvm.thread.samethread;

import java.util.concurrent.*;

public class SingleThreadConcurrencyMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i <= 8; i++) {

            int total = (int) Math.pow(10, i);
            long start = System.currentTimeMillis();
            for (int j = 0; j < total; j++){
                executorService.execute(new SlowTask());
            }

            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

            long finish = System.currentTimeMillis();
            System.out.println("SingleThreadConcurrencyMain -> 运行 SlowTask " + total + "次，花费时间: " + (finish - start) + " milliseconds");

            executorService = Executors.newSingleThreadExecutor();
        }
    }
}
