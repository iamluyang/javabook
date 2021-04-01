package online.javabook.jvm.thread.jcu.lock.aqs;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleCASLock {

    private SimpleAQSNode currentAQSNode;

    private Queue<SimpleAQSNode> waitingThreads = new LinkedList<>();

    public void lock() throws InterruptedException {
        SimpleAQSNode current = new SimpleAQSNode(Thread.currentThread());
        synchronized (this) {
            waitingThreads.add(current);
        }

        while (true) {
            SimpleAQSNode head = waitingThreads.peek();
            if (head == null) return;
            boolean isLockedForThisThread = head.equals(current);

            synchronized (this) {
                if (isLockedForThisThread) {
                    currentAQSNode = current;
                    return;
                }
            }
        }
    }

    public void unlock() throws InterruptedException {
        while (true) {
            SimpleAQSNode head = waitingThreads.peek();
            if (head == null) return;

            boolean isLockedForThisThread = head.equals(currentAQSNode);
            if (isLockedForThisThread) {
                synchronized (this) {
                    waitingThreads.poll();
                    currentAQSNode = null;
                    return;
                }
            }
        }
    }
}
