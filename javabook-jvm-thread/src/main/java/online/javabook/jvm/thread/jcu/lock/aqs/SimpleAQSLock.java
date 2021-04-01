package online.javabook.jvm.thread.jcu.lock.aqs;

import java.util.ArrayList;
import java.util.List;

public class SimpleAQSLock {

    private boolean isLocked = false;

    private Thread lockingThread = null;

    private List<SimpleAQSNode> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {

        SimpleAQSNode simpleAQSNode = new SimpleAQSNode();
        boolean isLockedForThisThread = true;

        // 该同步块保障按照线程进入的先后顺序添加simpleAQSObject
        synchronized (this) {
            waitingThreads.add(simpleAQSNode);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waitingThreads.get(0) != simpleAQSNode;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    lockingThread = Thread.currentThread();
                    waitingThreads.remove(simpleAQSNode);
                    return;
                }
            }

            try {
                simpleAQSNode.doWait();
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(simpleAQSNode);
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
