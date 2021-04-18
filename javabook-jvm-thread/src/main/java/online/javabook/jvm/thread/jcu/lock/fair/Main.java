package online.javabook.jvm.thread.jcu.lock.fair;

import online.javabook.jvm.thread.performance.CounterPerformance;
import online.javabook.jvm.thread.sync.*;

import java.util.concurrent.CountDownLatch;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.printf("%-60s%30s%30s%30s\n", "Class", "Time(Nano)", "Actual value", "Expected value");

		System.out.println("short task:");
		CounterPerformance.performance(new ReentrantNoFairLockWithExecutionTimeCounterImpl(1), 10, 1000);
		CounterPerformance.performance(new ReentrantFairLockWithExecutionTimeCounterImpl(1), 10, 1000);

		System.out.println("long task:");
		CounterPerformance.performance(new ReentrantNoFairLockWithExecutionTimeCounterImpl(2000), 10, 1000);
		CounterPerformance.performance(new ReentrantFairLockWithExecutionTimeCounterImpl(2000), 10, 1000);
	}

}
