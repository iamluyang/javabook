package online.javabook.jcu.executor;

import java.util.HashMap;
import java.util.concurrent.*;

public class NewSingleThreadExecutor {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread() + " - Start thread");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+":is running:" +i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            executorService.execute(runnable);
            Thread.sleep(5000);
        }
    }
}
