package online.javabook.jcu.executor.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSingleThreadExecutorExceptionMain {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread() + " - Start thread");
                int a = 100/0;
            }
        };

        for (int i = 0; i < 10; i++) {
            executorService.execute(runnable);
            Thread.sleep(5000);
        }
    }
}
