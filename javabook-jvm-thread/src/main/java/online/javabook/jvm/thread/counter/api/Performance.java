package online.javabook.jvm.thread.counter.api;

import online.javabook.jvm.thread.counter.api.ICounter;

import java.util.concurrent.CountDownLatch;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public class Performance {
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

		long begin = System.currentTimeMillis();
		finishCountDown.await();
		long finish = System.currentTimeMillis();

		System.out.printf("%-60s%30s%30s%30s%30s\n", counter.getClass().getSimpleName(), (finish - begin), totalThreads, counter.get(), total);
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
