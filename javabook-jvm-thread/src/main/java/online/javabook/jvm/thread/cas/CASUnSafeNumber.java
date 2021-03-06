package online.javabook.jvm.thread.cas;

import online.javabook.jvm.thread.unsafe.MyUnsafe;
import sun.misc.Unsafe;

public class CASUnSafeNumber {

    private volatile long value;

    private static final Unsafe unsafe = MyUnsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(CASUnSafeNumber.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    /**
     * @return
     */
    public long get() {
        return value;
    }

    /**
     * synchronized关键字是为了保障这个方法的原子性，用来模拟底层的CAS接口的原子操作
     * @param expect
     * @param update
     * @return
     */
    public boolean compareAndSet(long expect, long update) {
        return MyUnsafe.getUnsafe().compareAndSwapLong(this, valueOffset, expect, update);
    }
}