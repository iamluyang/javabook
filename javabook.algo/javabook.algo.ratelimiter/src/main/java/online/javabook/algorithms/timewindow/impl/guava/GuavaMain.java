package online.javabook.algorithms.timewindow.impl.guava;

import com.google.common.util.concurrent.RateLimiter;

public class GuavaMain {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(10);
    }
}
