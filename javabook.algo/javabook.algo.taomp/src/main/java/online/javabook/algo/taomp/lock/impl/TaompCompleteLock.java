package online.javabook.algo.taomp.lock.impl;

import online.javabook.algo.taomp.lock.api.SimpleLock;

import java.util.concurrent.TimeUnit;

/**
 * 相比{@link SimpleLock}，API更完整的锁接口。
 *
 * @author Robin Wang
 */
public interface TaompCompleteLock extends SimpleLock {

    /**
     * @param time 最大等待时间
     * @param unit 时间单位
     *
     * @return 如果获得锁返回true，否则返回false
     *
     * @throws InterruptedException 当尝试获得锁时，线程被中断时抛出
     */
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
}