package online.javabook.jvm.thread.jcu.lock.simple;

import java.util.ArrayList;
import java.util.List;

public class JavaSynchronizedQueueLock {

    private boolean isLocked = false;

    private Thread lockingThread = null;

    private List<JavaSynchronizedQueueNode> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {

        JavaSynchronizedQueueNode simpleAQSObject = new JavaSynchronizedQueueNode();
        boolean isLockedForThisThread = true;

        // 该同步块保障按照线程进入的先后顺序添加simpleAQSObject
        synchronized (this) {
            waitingThreads.add(simpleAQSObject);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waitingThreads.get(0) != simpleAQSObject;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    lockingThread = Thread.currentThread();
                    waitingThreads.remove(simpleAQSObject);
                    return;
                }
            }

            try {
                simpleAQSObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(simpleAQSObject);
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
