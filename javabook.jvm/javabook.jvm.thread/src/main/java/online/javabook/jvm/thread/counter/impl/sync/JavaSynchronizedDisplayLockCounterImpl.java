package online.javabook.jvm.thread.counter.impl.sync;

import online.javabook.jvm.thread.counter.api.ICounter;

/**
 * 基于显示同步锁的计数器实现
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class JavaSynchronizedDisplayLockCounterImpl implements ICounter {

	/**
	 * lock
	 */
	final JavaSynchronizedDisplayLock lock = new JavaSynchronizedDisplayLock();

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