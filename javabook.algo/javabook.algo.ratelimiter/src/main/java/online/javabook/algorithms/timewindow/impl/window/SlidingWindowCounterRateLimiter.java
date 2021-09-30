package online.javabook.algorithms.timewindow.impl.window;

import online.javabook.algorithms.ratelimiter.api.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowCounterRateLimiter extends RateLimiter {

    // TODO: Clean up stale entries
    private final ConcurrentMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();

    public SlidingWindowCounterRateLimiter(int maxRequestPerSecond) {
        super(maxRequestPerSecond);
    }

    @Override
    public boolean allow() {
        // currentWindowKey
        long currentTimeMillis = System.currentTimeMillis();
        long currentsWindowKey = currentTimeMillis / 1000 * 1000;
        windows.putIfAbsent(currentsWindowKey, new AtomicInteger(0));

        // first second
        long previousWindowKey = currentsWindowKey - 1000;
        AtomicInteger previousCount = windows.get(previousWindowKey);
        if (previousCount == null) {
            return windows.get(currentsWindowKey).incrementAndGet() <= maxRequestPerSecond;
        }

        // next seconds
        double previousWeight = 1 - (currentTimeMillis - currentsWindowKey) / 1000.0;
        long count = (long) (previousCount.get() * previousWeight + windows.get(currentsWindowKey).incrementAndGet());
        return count <= maxRequestPerSecond;
    }
}