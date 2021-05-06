package online.javabook.jcu.queue.blocking;

import java.util.LinkedList;
import java.util.List;

public class SynchronizedBlockingQueue {

    private int limit = 10;

    private List queue = new LinkedList();

    public SynchronizedBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {

        while (this.queue.size() == this.limit) {
            wait();// 如果队列到达上限，则调用enqueue的线程进入等待
        }

        this.queue.add(item);
        notifyAll(); // 当有数据进入队列，唤醒那些等待的线程重新参与下一轮的锁竞争
    }


    public synchronized Object dequeue() throws InterruptedException {

        while (this.queue.size() == 0) {
            wait();// 如果队列已经为空，则调用dequeue的线程进入等待
        }

        notifyAll(); // 当有数据离开队列，唤醒那些等待的线程重新参与下一轮的锁竞争
        return this.queue.remove(0);
    }

}
