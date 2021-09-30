package online.javabook.jcu.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPoolMain {
    public static void main(String[] args) throws InterruptedException {

        Executors.defaultThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool();
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

        for (int i = 0; i < 5; i++) {
            executorService.execute(runnable);
            // 尝试快速的创建任务(创建了5个线程)和间隔3秒的创建任务(重用闲置的线程)
            Thread.sleep(3000);
        }
    }
}
