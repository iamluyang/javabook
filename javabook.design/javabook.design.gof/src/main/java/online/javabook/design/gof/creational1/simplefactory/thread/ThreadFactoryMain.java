package online.javabook.design.gof.creational1.simplefactory.thread;

import java.util.concurrent.*;

public class ThreadFactoryMain {
    public static void main(String[] args) {
        // fixedThreadPool
        new ThreadPoolExecutor(
                5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        // cachedThreadPool
        new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    }
}
