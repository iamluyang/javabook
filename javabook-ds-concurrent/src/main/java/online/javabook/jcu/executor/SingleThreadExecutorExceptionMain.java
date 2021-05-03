package online.javabook.jcu.executor;

import java.util.HashMap;
import java.util.concurrent.*;

public class SingleThreadExecutorExceptionMain {
    public static void main(String[] args) throws InterruptedException {

        Executors.defaultThreadFactory();
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
