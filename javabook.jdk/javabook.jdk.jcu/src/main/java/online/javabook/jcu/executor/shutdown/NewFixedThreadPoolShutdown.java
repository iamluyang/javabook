package online.javabook.jcu.executor.shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewFixedThreadPoolShutdown {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 10; i++) {
            executorService.execute(new MyRunnable("MyRunnable-"+i));
        }
        Thread.sleep(2000);

        // shutdown前提交的任务如果已经中执行中，不会被打断
        // shutdown前提交的任务如果已经在队列中，不会被取消
        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);

        System.out.println("线程池关闭状态:"+executorService.isShutdown());
        System.out.println("线程池终止状态:"+executorService.isTerminated());

        // shutdown后再提交的任务会被拒绝
        executorService.execute(new MyRunnable("MyRunnable-11"));
    }

    private static class MyRunnable implements Runnable {

        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        public void run() {
            System.out.println(Thread.currentThread() + " - Start Runnable " + name);

            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+":is running:" +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
