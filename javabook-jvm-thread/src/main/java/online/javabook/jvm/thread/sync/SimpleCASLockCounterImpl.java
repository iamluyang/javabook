package online.javabook.jvm.thread.sync;

import online.javabook.jvm.thread.jcu.lock.aqs.SimpleAQSLock;
import online.javabook.jvm.thread.jcu.lock.aqs.SimpleCASLock;

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
public final class SimpleCASLockCounterImpl implements ICounter {

	/**
	 * lock
	 */
	final SimpleCASLock lock = new SimpleCASLock();

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