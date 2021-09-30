package online.javabook.algorithms.ratelimiter.api;

public abstract class RateLimiter {

    protected final int maxRequestPerSecond;

    public RateLimiter(int maxRequestPerSecond) {
        this.maxRequestPerSecond = maxRequestPerSecond;
    }

    public abstract boolean allow();
}