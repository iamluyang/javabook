package online.javabook.jvm.thread.jcu.lock.fair;

import online.javabook.jvm.thread.counter.api.Performance;

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
		Performance.performance(new JcuReentrantNoFairLockCounterImpl(1), 10, 1000);
		Performance.performance(new JcuReentrantFairLockCounterImpl(1), 10, 1000);

		System.out.println("long task:");
		Performance.performance(new JcuReentrantNoFairLockCounterImpl(2000), 10, 1000);
		Performance.performance(new JcuReentrantFairLockCounterImpl(2000), 10, 1000);
	}

}
