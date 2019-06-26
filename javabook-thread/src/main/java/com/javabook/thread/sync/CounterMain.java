package com.javabook.thread.sync;

import java.util.concurrent.CountDownLatch;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015-1-27
 *
 */
public class CounterMain {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		test(new UnsafeCounterImpl());
		test(new VolatileCounterImpl());

		test(new AtomicCounterImpl());
		test(new NoFairCounterImpl());

		test(new SynchrCounterImpl());
		test(new FairCounterImpl());

	}

	/**
	 * @param counter
	 * @throws InterruptedException
	 */
	public static void test(final ICounter counter) throws InterruptedException {

		int threadCount = 1000;
		int increment = 1000;
		CountDownLatch startCountDown = new CountDownLatch(1);
		CountDownLatch finishCountDown = new CountDownLatch(threadCount);

		for (int count = 1; count <= threadCount; count++) {
			Thread runner = new Thread(new Running(counter, increment,
					startCountDown, finishCountDown));
			runner.start();
		}

		startCountDown.countDown();
		long begin = System.nanoTime();
		finishCountDown.await();
		long finish = System.nanoTime();

		System.out.println(counter.getClass().getSimpleName() + "\t\tTime:"
				+ (finish - begin) + "\tNanos." + "\t\tCount : "
				+ counter.get());
	}

	static class Running implements Runnable {

		private int increment;
		private ICounter counter;
		private CountDownLatch startCountDown;
		private CountDownLatch finishCountDown;

		public Running(ICounter counter, int increment,
				CountDownLatch startCountDown, CountDownLatch finishCountDown) {
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
