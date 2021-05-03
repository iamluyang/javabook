package online.javabook.jvm.thread.lock.notreentrant;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 这是一个不能重入的锁
 */
public class SimpleNotReentrantLock {

    private boolean isLocked = false;

    private AtomicReference reference = new AtomicReference();

    /**
     * 当一个线程尚未释放第一个锁的前提下，该线程再次获取lock时会进入wait造成死锁
     * @throws InterruptedException
     */
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            if(reference.get() == Thread.currentThread()) {
                System.out.println(Thread.currentThread() + " 再次尝试拿锁.");
                System.out.println(Thread.currentThread() + " 死锁了，当前线程在等待自己释放锁");
            }
            else{
                System.out.println(Thread.currentThread() + " 等待锁.");
            }
            wait();
        }

        reference.set(Thread.currentThread());
        System.out.println(Thread.currentThread() + " 获得锁.");
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;

        reference.set(null);
        System.out.println(Thread.currentThread() + " unlock.");
        notify();
    }
}
