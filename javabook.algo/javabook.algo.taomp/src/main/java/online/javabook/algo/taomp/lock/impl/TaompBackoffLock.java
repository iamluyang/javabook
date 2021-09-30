package online.javabook.algo.taomp.lock.impl;

import online.javabook.algo.taomp.lock.api.SimpleLock;

import java.util.concurrent.atomic.AtomicBoolean;


/**
 * 使用了{@link com.github.mottox.taomp.common.Backoff}的锁。
 */
public class TaompBackoffLock implements SimpleLock {

    private AtomicBoolean state = new AtomicBoolean(false);

    private static final int MIN_DELAY = 50;

    private static final int MAX_DELAY = 80;

    @Override
    public void lock() {
        TaompBackoff backoff = new TaompBackoff(MIN_DELAY, MAX_DELAY);
        while (true) {
            // 锁已经被占用，则等待
            while (state.get()) {
            }
            // 成功占有锁
            if (!state.getAndSet(true)) {
                return;
            } else {
                // 后退
                try {
                    backoff.backoff();
                } catch (InterruptedException e) {
                    // 留空
                }
            }
        }
    }

    @Override
    public void unlock() {
        state.set(false);
    }

}