package online.javabook.algorithms.ratelimiter.api;

import online.javabook.algorithms.timewindow.impl.window.FixedWindowCounterRateLimiter;
import online.javabook.algorithms.timewindow.impl.window.SlidingWindowCounterRateLimiter;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new SlidingWindowCounterRateLimiter(10);

        Thread thread = new Thread(() -> {
            while (true) {
                boolean allow = rateLimiter.allow();
                if (!allow) {
                    System.out.println(Calendar.getInstance().getTime());
                }
                try {
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
