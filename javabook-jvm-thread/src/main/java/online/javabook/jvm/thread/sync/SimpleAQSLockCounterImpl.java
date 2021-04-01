package online.javabook.jvm.thread.sync;

import online.javabook.jvm.thread.jcu.lock.aqs.SimpleAQSLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <ul>
 * 基于简单实现的AQSLock
 * <li>
 * </ul>
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class SimpleAQSLockCounterImpl implements ICounter {

	/**
	 * lock
	 */
	final SimpleAQSLock lock = new SimpleAQSLock();

	/**
	 * value
	 */
	private long value = 0;

	@Override
	public long get() {
		return value;
	}

	@Override
	public long increment() throws InterruptedException {
		lock.lock();
		try {
			value++;
			return value;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public long decrement() throws InterruptedException {
		lock.lock();
		try {
			value--;
			return value;
		} finally {
			lock.unlock();
		}
	}
}