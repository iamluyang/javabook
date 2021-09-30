package online.javabook.algorithms.timewindow.impl.token;

import online.javabook.algorithms.ratelimiter.api.RateLimiter;

import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter extends RateLimiter {

    private int tokens;

    public TokenBucketRateLimiter(int maxRequestsPerSec) {
        super(maxRequestsPerSec);
        this.tokens = maxRequestsPerSec;
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refillTokens(maxRequestsPerSec);
            }
        }).start();
    }

    @Override
    public boolean allow() {
        synchronized (this) {
            if (tokens == 0) {
                return false;
            }
            tokens--;
            return true;
        }
    }

    private void refillTokens(int cnt) {
        synchronized (this) {
            tokens = Math.min(tokens + cnt, maxRequestPerSecond);
            notifyAll();
        }
    }
}
