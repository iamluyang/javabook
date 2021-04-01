package online.javabook.jvm.thread.jcu.lock.aqs;

public class SimpleAQSNode {

    /**
     * thread
     */
    private Thread thread;

    /**
     * thread
     */
    private long timestamp;

    /**
     * is Notified
     */
    private boolean isNotified = false;

    public SimpleAQSNode(Thread thread) {
        this.thread = thread;
        this.timestamp = System.nanoTime();
    }

    public SimpleAQSNode() {

    }

    public Thread getThread() {
        return thread;
    }

    public synchronized void doWait() throws InterruptedException {
        while (!isNotified) {
            this.wait();
        }
        this.isNotified = false;
    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    public boolean equals(Object object) {
        if(object == null) return false;
        SimpleAQSNode that = (SimpleAQSNode)object;
        return this.thread == that.thread && this.timestamp == that.timestamp;
    }
}
