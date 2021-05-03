package online.javabook.jvm.thread.counter.api;

import online.javabook.jvm.thread.counter.impl.taomp.*;

public class Main {
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {

        System.out.printf("%-60s%30s%30s%30s%30s\n", "Class", "Time(Nano)", "Threads", "Actual value", "Expected value");

        int total = 128;
        for (int i = 1; i <= 1;) {
            int unit = total / i;
            //CounterPerformance.performance(new JCUReentrantNoFairLockCounterImpl(), i, unit);
/*            CounterPerformance.performance(new UnsafeThreadCounterImpl(), i, unit);
            CounterPerformance.performance(new UnsafeVolatileCounterImpl(), i, unit);
            CounterPerformance.performance(new JavaSynchronizedKeywordLockCounterImpl(), i, unit);
            CounterPerformance.performance(new JavaSynchronizedDisplayLockCounterImpl(), i, unit);
            CounterPerformance.performance(new JavaSynchronizedQueueLockCounterImpl(), i, unit);
            CounterPerformance.performance(new JCUAtomicLongCounterImpl(), i, unit);
            CounterPerformance.performance(new JCUAQSLockCounterImpl(), i, unit);
            CounterPerformance.performance(new JCUReentrantNoFairLockCounterImpl(), i, unit);
            CounterPerformance.performance(new JCUReentrantFairLockCounterImpl(), i, unit);
            CounterPerformance.performance(new CASSyncCounterImpl(), i, unit);
            CounterPerformance.performance(new CASUnsafeCounterImpl(), i, unit);
            CounterPerformance.performance(new TaompTASLockCounterImpl(), i, unit);
            CounterPerformance.performance(new TaompTTASLockCounterImpl(), i, unit);
            CounterPerformance.performance(new TaompBackoffLockCounterImpl(), i, unit);
            CounterPerformance.performance(new TaompALockCounterImpl(), i, unit);
            CounterPerformance.performance(new TaompMCSLockCounterImpl(), i, unit);
            CounterPerformance.performance(new TaompTOLockCounterImpl(), i, unit);*/
            Performance.performance(new TaompCLHLockCounterImpl(), i, unit);

            i = i * 2;
        }

    }
}
