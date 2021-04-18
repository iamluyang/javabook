package online.javabook.jvm.thread.sync;

import online.javabook.jvm.thread.performance.CounterPerformance;

public class Main {
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {

        System.out.printf("%-60s%30s%30s%30s\n", "Class", "Time(Nano)", "Actual value", "Expected value");

        CounterPerformance.performance(new UnsafeThreadCounterImpl(), 10, 100000);
        CounterPerformance.performance(new UnsafeVolatileCounterImpl(), 10, 100000);

        CounterPerformance.performance(new JavaSynchronizedKeywordCounterImpl(), 10, 100000);
        CounterPerformance.performance(new JavaSynchronizedLockCounterImpl(), 10, 100000);

        CounterPerformance.performance(new JavaSynchronizedCASCounterImpl(), 10, 100000);
        CounterPerformance.performance(new JavaUnsafeCASCounterImpl(), 10, 100000);

        CounterPerformance.performance(new JCUAtomicLongCounterImpl(), 10, 100000);
        CounterPerformance.performance(new JCUReentrantNoFairLockCounterImpl(), 10, 100000);
        CounterPerformance.performance(new JCUReentrantFairLockCounterImpl(), 10, 100000);

        CounterPerformance.performance(new JavaSynchronizedQueueCounterImpl(), 10, 100000);
        CounterPerformance.performance(new JavaConCurrentAQSSLockCounterImpl(), 4, 250000);

        //CounterPerformance.performance(new SimpleToryAQSLockCounterImpl(), 4, 250000);

    }
}
