package online.javabook.jvm.thread.sync.main;

import online.javabook.jvm.thread.sync.SynchronizedCASCounterImpl;
import online.javabook.jvm.thread.sync.*;

import java.util.concurrent.CountDownLatch;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public class CounterPerformanceMain {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.printf("%-30s%20s%20s%20s\n", "Class", "Time(Nano)", "Actual value", "Expected value");

/*		performance(new UnsafeThreadCounterImpl(), 10, 100000);
		performance(new VolatileCounterImpl(), 10, 100000);

		performance(new AtomicLongCounterImpl(), 10, 100000);
		performance(new SynchronizedCASCounterImpl(), 10, 100000);

		performance(new ReentrantNoFairLockCounterImpl(), 10, 100000);
		performance(new ReentrantFairLockCounterImpl(), 10, 100000);

		performance(new SynchronizedJavaCounterImpl(), 10, 100000);
		performance(new SynchronizedLockCounterImpl(), 10, 100000);

		performance(new SimpleAQSLockCounterImpl(), 10, 100000);*/

		performance(new ReentrantNoFairLockCounterImpl(), 10, 100000);
		performance(new SimpleCASLockCounterImpl(), 10, 100);
	}

	/**
	 *
	 * @param counter
	 * @param totalThreads
	 * @param incrementsPreThread
	 * @throws InterruptedException
	 */
	public static void performance(final ICounter counter, int totalThreads, int incrementsPreThread) throws InterruptedException {

		long total = incrementsPreThread * totalThreads;
		CountDownLatch startCountDown = new CountDownLatch(1);
		CountDownLatch finishCountDown = new CountDownLatch(totalThreads);

		for (int count = 1; count <= totalThreads; count++) {
			Thread runner = new Thread(new Running(counter, incrementsPreThread, startCountDown, finishCountDown));
			runner.start();
		}
		startCountDown.countDown();

		long begin = System.nanoTime();
		finishCountDown.await();
		long finish = System.nanoTime();

		System.out.printf("%-30s%20s%20s%20s\n", counter.getClass().getSimpleName(), (finish - begin), counter.get(), total);
	}

	static class Running implements Runnable {

		private int increment;
		private ICounter counter;
		private CountDownLatch startCountDown;
		private CountDownLatch finishCountDown;

		public Running(ICounter counter, int increment,	CountDownLatch startCountDown, CountDownLatch finishCountDown) {
			this.counter = counter;
			this.increment = increment;
			this.startCountDown = startCountDown;
			this.finishCountDown = finishCountDown;
		}

		@Override
		public void run() {
			try {
				startCountDown.await();
				for (int i = 0; i < increment; i++) {
					counter.increment();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				finishCountDown.countDown();
			}
		}
	}

}
