package online.javabook.jcu.executor.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPoolExceptionMain {
    public static void main(String[] args) throws InterruptedException {

        Executors.defaultThreadFactory();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread() + " - Start thread");
                int a = 100/0;
            }
        };

        for (int i = 1; i <= 6; i++) {
            executorService.execute(runnable);
            Thread.sleep(1000);
        }
    }
}
