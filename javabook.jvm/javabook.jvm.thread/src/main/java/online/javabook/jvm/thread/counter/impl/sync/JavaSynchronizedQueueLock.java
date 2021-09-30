package online.javabook.jvm.thread.counter.impl.sync;

import java.util.ArrayList;
import java.util.List;

public class JavaSynchronizedQueueLock {

    private boolean isLocked = false;

    private Thread lockingThread = null;

    private List<JavaSynchronizedQueueLockNode> waitingThreads = new ArrayList();

    public void lock() throws InterruptedException {

        JavaSynchronizedQueueLockNode node = new JavaSynchronizedQueueLockNode();
        boolean isLockedForThisThread = true;

        // 该同步块保障按照线程进入的先后顺序添加simpleAQSObject
        synchronized (this) {
            waitingThreads.add(node);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waitingThreads.get(0) != node;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    waitingThreads.remove(node);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }

            try {
                node.doWait();
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(node);
                }
                throw e;
            }
        }
    }

    public synchronized void unlock() {

        // 如果当前线程没有持有锁，则无法调用该方法解锁
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }

        // 如果当前线程解锁会将锁的内部状态置空
        isLocked = false;
        lockingThread = null;
        if (waitingThreads.size() > 0) {
            waitingThreads.get(0).doNotify();
        }
    }
}
