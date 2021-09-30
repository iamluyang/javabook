package online.javabook.jcu.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPool {
    public static void main(String[] args) throws InterruptedException {

        Executors.defaultThreadFactory();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread() + " - Start thread");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        for (int i = 1; i <= 4; i++) {
            executorService.execute(runnable);
            Thread.sleep(1000);
        }
    }
}
