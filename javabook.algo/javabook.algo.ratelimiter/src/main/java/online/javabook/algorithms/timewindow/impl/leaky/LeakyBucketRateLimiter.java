package online.javabook.algorithms.timewindow.impl.leaky;

import online.javabook.algorithms.ratelimiter.api.RateLimiter;

public class LeakyBucketRateLimiter extends RateLimiter {

    private long nextTimeMillis;

    private final long REQUEST_INTERVAL_MILLIS;

    public LeakyBucketRateLimiter(int maxRequestPerSecond) {
        super(maxRequestPerSecond);
        REQUEST_INTERVAL_MILLIS = 1000 / maxRequestPerSecond;
        nextTimeMillis = System.currentTimeMillis();
    }

    @Override
    public boolean allow() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (currentTimeMillis >= nextTimeMillis) {
                nextTimeMillis = currentTimeMillis + REQUEST_INTERVAL_MILLIS;
                return true;
            }
            return false;
        }
    }
}