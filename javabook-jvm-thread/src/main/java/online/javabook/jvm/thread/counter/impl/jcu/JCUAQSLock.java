package online.javabook.jvm.thread.counter.impl.jcu;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class JCUAQSLock extends AbstractQueuedSynchronizer {

    public void lock () {
        this.acquire(1);
    }

    public void unlock () {
        this.release(1);
    }

    @Override
    protected boolean tryAcquire (int arg) {
        return compareAndSetState(0, 1);
    }

    @Override
    protected boolean tryRelease (int arg) {
        setState(0);
        return true;
    }

    @Override
    protected boolean isHeldExclusively () {
        return getState() == 1;
    }
}