package online.javabook.jvm.thread.counter.api;

import online.javabook.jvm.thread.counter.impl.bad.UnsafeThreadCounterImpl;
import online.javabook.jvm.thread.counter.impl.bad.UnsafeVolatileCounterImpl;
import online.javabook.jvm.thread.counter.impl.cas.CASSynchronizedCounterImpl;
import online.javabook.jvm.thread.counter.impl.cas.CASUnsafeCounterImpl;
import online.javabook.jvm.thread.counter.impl.jcu.JCUAQSLockCounterImpl;
import online.javabook.jvm.thread.counter.impl.jcu.JCUAtomicLongCounterImpl;
import online.javabook.jvm.thread.counter.impl.jcu.JCUReentrantFairLockCounterImpl;
import online.javabook.jvm.thread.counter.impl.jcu.JCUReentrantNoFairLockCounterImpl;
import online.javabook.jvm.thread.counter.impl.sync.JavaSynchronizedDisplayLockCounterImpl;
import online.javabook.jvm.thread.counter.impl.sync.JavaSynchronizedKeywordLockCounterImpl;

public class Main {
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {

        System.out.printf("%-40s%20s%20s%20s%20s\n", "Class", "Time(Mill)", "Threads", "Actual value", "Expected value");

        int total = 12800000;
        for (int i = 8; i <= 8; ) {
            int unit = total / i;
            Performance.performance(new UnsafeThreadCounterImpl(), i, unit);
            Performance.performance(new UnsafeVolatileCounterImpl(), i, unit);

            Performance.performance(new JavaSynchronizedDisplayLockCounterImpl(), i, unit);
            Performance.performance(new JavaSynchronizedKeywordLockCounterImpl(), i, unit);
            //Performance.performance(new JavaSynchronizedQueueLockCounterImpl(), i, unit);

            Performance.performance(new CASUnsafeCounterImpl(), i, unit);
            Performance.performance(new CASSynchronizedCounterImpl(), i, unit);

            Performance.performance(new JCUAQSLockCounterImpl(), i, unit);
            Performance.performance(new JCUAtomicLongCounterImpl(), i, unit);
            Performance.performance(new JCUReentrantFairLockCounterImpl(), i, unit);
            Performance.performance(new JCUReentrantNoFairLockCounterImpl(), i, unit);

            i = i * 2;
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
        }

    }
}
