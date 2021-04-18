package online.javabook.jvm.thread.jcu.lock.simple;

public class JavaSynchronizedQueueNode {

    /**
     * is Notified
     */
    private boolean isNotified = false;

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
}
