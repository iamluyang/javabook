package online.javabook.algo.taomp.lock.api;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * TAOMP中简化版的{@link Lock}。
 */
public interface SimpleLock extends Lock {

    /**
     * 在进入临界区之前调用。
     */
    void lock();

    /**
     * 在离开临界区之前调用。
     */
    void unlock();

    @Override
    default void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    default boolean tryLock() {
        throw new UnsupportedOperationException();
    }

    @Override
    default boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    default Condition newCondition() {
        throw new UnsupportedOperationException();
    }
}