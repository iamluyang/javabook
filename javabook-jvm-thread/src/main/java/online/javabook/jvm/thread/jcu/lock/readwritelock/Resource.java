package online.javabook.jvm.thread.jcu.lock.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Resource {

    /**
     * buffer
     */
    private final char[] context;

    /**
     * lock
     */
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public Resource() {
        this.context = new char[10];
        for (int index = 0; index < context.length; index++) {
            context[index] = '*';
        }
    }

    /**
     * @return
     * @throws InterruptedException
     */
    public char[] read() throws InterruptedException {
        lock.readLock().lock();
        try {
            return doRead();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * @return
     */
    private char[] doRead() {
        char[] newContext = new char[context.length];
        for (int i = 0; i < context.length; i++) {
            newContext[i] = context[i];
        }
        slowly();
        return newContext;
    }

    /**
     * @param c
     * @throws InterruptedException
     */
    public void write(char c) throws InterruptedException {
        lock.writeLock().lock();
        try {
            doWrite(c);
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * @param c
     */
    private void doWrite(char c) {
        for (int index = 0; index < context.length; index++) {
            context[index] = c;
            slowly();
        }
    }

    /**
     *
     */
    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }
}
