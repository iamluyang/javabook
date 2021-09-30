package online.javabook.jcu.executor.rejected;

import java.util.concurrent.*;

public class ThreadPoolExecutorDiscardOldestPolicyDemo {
    public static void main(String[] args) throws InterruptedException {

        // 最多可以运行几个任务: 4 = 2个线程各执行一个任务 + 队列里面还能放两个等待执行
        // 处理不过来的时候先将队列中头部的任务抛弃
        ExecutorService executorService = new ThreadPoolExecutor(
                2, 2,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 1; i <= 10; i++) {
            executorService.execute(new MyRunnable("MyRunnable-"+i));
            //Thread.sleep(1000);
        }
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
