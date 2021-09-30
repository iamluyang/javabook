package online.javabook.jcu.executor.shutdown;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewFixedThreadPoolShutdownNow {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 10; i++) {
            executorService.execute(new MyRunnable("MyRunnable-"+i));
        }
        Thread.sleep(2000);

        // shutdown前提交的任务如果已经中执行中，将会被打断
        // shutdown前提交的任务如果已经在队列中，将不会执行，并且会返回不再执行任务的列表
        List<Runnable> runnables = executorService.shutdownNow();
        executorService.awaitTermination(100, TimeUnit.SECONDS);

        for (Runnable runnable : runnables) {
            System.out.println("被取消执行的任务:"+((MyRunnable)runnable).getName());
        }

        System.out.println("线程池关闭状态:"+executorService.isShutdown());
        System.out.println("线程池终止状态:"+executorService.isTerminated());

        // shutdownNow后再提交的任务会被拒绝
        executorService.execute(new MyRunnable("MyRunnable-11"));
    }

    private static class MyRunnable implements Runnable {

        private String name;

        public String getName() {
            return name;
        }

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
                    throw new RuntimeException("["+name+"]被打断了");
                }
            }
        }
    }
}
