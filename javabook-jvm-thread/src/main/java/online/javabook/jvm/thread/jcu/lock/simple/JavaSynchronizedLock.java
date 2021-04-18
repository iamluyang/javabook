package online.javabook.jvm.thread.jcu.lock.simple;

/**
 * 基于synchronized实现的显示锁
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public class JavaSynchronizedLock {

    private boolean isLocked = false;

    private Thread lockingThread = null;

    public synchronized void lock() throws InterruptedException {

        // 1. 首先这个wait等待代码块不是用于第一个获取锁的线程的
        // 2. “第一个“获得锁的线程离开该同步块就会释放该SynchronizedLock实例锁
        // 3. 因此我们需要通过程序逻辑来阻止其他线程也拿到SynchronizedLock实例锁后做进一步的操作，因此应该让后续线程进入等待区
        while (isLocked) {
            wait();
        }

        // “第一个“线程设置SynchronizedLock实例的状态为锁定
        isLocked = true;
        // “第一个“线程将自身作为状态设置到lock中，表示当前lock被该线程持有
        lockingThread = Thread.currentThread();
    }

    /**
     * 1. “第一个“获得锁的线程事实上在离开lock方法的synchronized块后就已经不再持有SynchronizedLock实例锁
     * 2. “第一个“获得锁的线程需要重新竞争才能获得SynchronizedLock实例锁并进入该unlock的解锁代码块
     */
    public synchronized void unlock() {

        // 为了避免其他线程在没有获得锁的前提下，随意调用解锁操作
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }

        // 如果解锁的线程和上一次获取锁的线程一致时，重置锁的状态，
        isLocked = false;
        lockingThread = null;

        // 当前即将解锁的线程唤醒其他尝试获取SynchronizedLock实例锁的线程重新进入下一轮的锁竞争
        notify();
    }
}
