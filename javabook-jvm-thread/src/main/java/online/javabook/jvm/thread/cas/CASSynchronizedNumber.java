package online.javabook.jvm.thread.cas;

public class CASSynchronizedNumber {

    /**
     * value
     */
    private int value;

    /**
     * @return
     */
    public synchronized int get() {
        return value;
    }

    /**
     * synchronized关键字是为了保障这个方法的原子性，用来模拟底层的CAS接口的原子操作
     * @param expect
     * @param update
     * @return
     */
    public synchronized boolean compareAndSet(int expect, int update) {

        if (value == expect) {
            value = update;
            return true;
        } else {
            return false;
        }
    }
}