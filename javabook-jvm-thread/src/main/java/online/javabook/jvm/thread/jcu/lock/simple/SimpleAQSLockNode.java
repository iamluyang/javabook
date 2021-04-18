package online.javabook.jvm.thread.jcu.lock.simple;

public class SimpleAQSLockNode {

    private Thread thread;

    public SimpleAQSLockNode(Thread thread) {
        this.thread = thread;
    }

    public Thread getThread() {
        return thread;
    }


    public boolean equals(Object object) {
        if(object == null) return false;
        SimpleAQSLockNode that = (SimpleAQSLockNode)object;
        return this.thread == that.thread;
    }
}
