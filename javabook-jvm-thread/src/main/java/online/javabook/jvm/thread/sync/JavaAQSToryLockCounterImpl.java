package online.javabook.jvm.thread.sync;

import online.javabook.jvm.thread.jcu.lock.simple.JavaAQSToryLock;

/**
 * 基于简单实现的CASLock
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class JavaAQSToryLockCounterImpl implements ICounter {

	/**
	 * lock
	 */
	final JavaAQSToryLock lock = new JavaAQSToryLock();

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