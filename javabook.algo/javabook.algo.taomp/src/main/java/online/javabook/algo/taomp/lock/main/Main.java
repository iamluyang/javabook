package online.javabook.algo.taomp.lock.main;

import online.javabook.algo.taomp.lock.impl.*;

public class Main {
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {

        System.out.printf("%-40s%20s%20s%20s%20s\n", "Class", "Time(Mill)", "Threads", "Actual value", "Expected value");

        int total = 12800000;
         for (int i = 8; i <= 8;) {
            int unit = total / i;

            Performance.performance(new TaompTASLockCounterImpl(), i, unit);
            Performance.performance(new TaompTTASLockCounterImpl(), i, unit);
            Performance.performance(new TaompBackoffLockCounterImpl(), i, unit);
            Performance.performance(new TaompALockCounterImpl(), i, unit);
            Performance.performance(new TaompMCSLockCounterImpl(), i, unit);
            Performance.performance(new TaompTOLockCounterImpl(), i, unit);
            Performance.performance(new TaompCLHLockCounterImpl(), i, unit);

            i = i * 2;
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
        }

    }
}
