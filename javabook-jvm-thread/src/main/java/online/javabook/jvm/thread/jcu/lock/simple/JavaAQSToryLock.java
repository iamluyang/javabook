package online.javabook.jvm.thread.jcu.lock.simple;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class JavaAQSToryLock {

    private AtomicBoolean isLock = new AtomicBoolean(false);

    private Queue<SimpleAQSLockNode> nodes = new ConcurrentLinkedQueue<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();
        SimpleAQSLockNode node = new SimpleAQSLockNode(currentThread);
        nodes.offer(node);

        boolean isHead = false;
        while (!isHead){
            if (!isLock.get()) {
                SimpleAQSLockNode head = nodes.peek();
                if(head == null) return;

                isHead = head.getThread().equals(currentThread);
                if(isHead) {
                    boolean isLocked = isLock.compareAndSet(false, true);
                    if (isLocked) {
                        return;
                    }
                }
            }
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();

        boolean isHead = false;
        //while (!isHead){
            if(isLock.get()){
                SimpleAQSLockNode head = nodes.peek();
                if(head == null) return;

                isHead = head.getThread().equals(currentThread);
                if(isHead){
                    boolean unLocked = isLock.compareAndSet(true, false);
                    if(unLocked) {
                        nodes.poll();
                        return;
                    }
                }
            }
        //}
    }
}
