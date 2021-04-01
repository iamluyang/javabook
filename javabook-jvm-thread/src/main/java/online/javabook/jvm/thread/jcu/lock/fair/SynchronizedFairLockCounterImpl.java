package online.javabook.jvm.thread.jcu.lock.fair;

import online.javabook.jvm.thread.sync.ICounter;

/**
 * <ul>
 * 如果有多个线程尝试调用synchronized方法，则其中一些线程将会被阻塞，直到第一个被授予访问的线程离开该方法为止
 * 如果阻塞了多个等待访问该synchronized方法的线程，则无法保证下次那一个线程有机会被赋予访问该synchronized块
 * <li>
 * </ul>
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class SynchronizedFairLockCounterImpl implements ICounter {

	/**
	 * value
	 */
	private long value = 0;

	@Override
	public synchronized long get() {
		return value;
	}

	@Override
	public synchronized long increment() {
		return value++;
	}

	@Override
	public synchronized long decrement() {
		return value--;
	}
}