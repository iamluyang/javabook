package online.javabook.algorithms.timewindow.impl.token;

import online.javabook.algorithms.ratelimiter.api.RateLimiter;

public class TokenBucketLazyRefillRateLimiter extends RateLimiter {

    private int tokens;

    private long lastRefillTime;

    public TokenBucketLazyRefillRateLimiter(int maxRequestPerSec) {
        super(maxRequestPerSec);
        this.tokens = maxRequestPerSec;
        this.lastRefillTime = System.currentTimeMillis();
    }

    @Override
    public boolean allow() {
        synchronized (this) {
            refillTokens();
            if (tokens == 0) {
                return false;
            }
            tokens--;
            return true;
        }
    }

    private void refillTokens() {
        long curTime = System.currentTimeMillis();
        double secSinceLastRefill = (curTime - lastRefillTime) / 1000.0;
        int cnt = (int) (secSinceLastRefill * maxRequestPerSecond);
        if (cnt > 0) {
            tokens = Math.min(tokens + cnt, maxRequestPerSecond);
            lastRefillTime = curTime;
        }
    }
}