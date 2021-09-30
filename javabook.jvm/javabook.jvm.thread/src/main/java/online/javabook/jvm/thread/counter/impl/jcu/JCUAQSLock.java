package online.javabook.jvm.thread.counter.impl.jcu;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class JCUAQSLock extends AbstractQueuedSynchronizer {

    public void lock() {
        acquire(1);
    }

    public void unlock() {
        release(1);
    }

    @Override
    protected boolean tryAcquire(int acquires) {
        final Thread current = Thread.currentThread();
        int c = getState();
        if (c == 0) {
            if (compareAndSetState(0, acquires)) {
                setExclusiveOwnerThread(current);
                return true;
            }
        }
        else if (current == getExclusiveOwnerThread()) {
            setState(c + acquires);
            return true;
        }
        return false;
    }

    @Override
    protected final boolean tryRelease(int releases) {
        int c = getState() - releases;
        if (Thread.currentThread() != getExclusiveOwnerThread())
            throw new IllegalMonitorStateException();

        if (c == 0) {
            setExclusiveOwnerThread(null);
        }
        setState(c);
        return true;
    }
}