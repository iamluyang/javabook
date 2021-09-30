package online.javabook.algorithms.timewindow.impl.window;

import online.javabook.algorithms.ratelimiter.api.RateLimiter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLogRateLimiter extends RateLimiter {

    private final Queue<Long> log = new LinkedList<>();

    public SlidingWindowLogRateLimiter(int maxRequestPerSecond) {
        super(maxRequestPerSecond);
    }

    @Override
    public boolean allow() {
        long curTime = System.currentTimeMillis();
        long boundary = curTime - 1000;
        synchronized (log) {
            while (!log.isEmpty() && log.element() <= boundary) {
                log.poll();
            }
            log.add(curTime);
            return log.size() <= maxRequestPerSecond;
        }
    }
}