package online.javabook.algorithms.timewindow.impl.window;

import online.javabook.algorithms.ratelimiter.api.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowCounterRateLimiter extends RateLimiter {

    // TODO: Clean up stale entries
    private final ConcurrentMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();

    public FixedWindowCounterRateLimiter(int maxRequestPerSecond) {
        super(maxRequestPerSecond);
    }

    @Override
    public boolean allow() {
        long windowKey = System.currentTimeMillis() / 1000 * 1000;
        windows.putIfAbsent(windowKey, new AtomicInteger(0));
        return windows.get(windowKey).incrementAndGet() <= maxRequestPerSecond;
    }
}