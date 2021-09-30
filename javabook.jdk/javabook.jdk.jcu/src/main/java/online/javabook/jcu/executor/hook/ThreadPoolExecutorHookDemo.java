package online.javabook.jcu.executor.hook;

import java.util.concurrent.*;

public class ThreadPoolExecutorHookDemo {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = new ThreadPoolExecutor(
                2, 2,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.DiscardPolicy()) {

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("我执行完了:" + t);
            }
        };

        for (int i = 1; i <= 4; i++) {
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
                    throw new RuntimeException("xxx");
                } catch (Exception e) {
                }
            }
        }
    }
}
