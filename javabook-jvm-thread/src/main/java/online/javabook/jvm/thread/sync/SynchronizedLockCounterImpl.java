package online.javabook.jvm.thread.sync;

import online.javabook.jvm.thread.jcu.lock.sync.SynchronizedLock;

/**
 * <ul>
 * 基于显示同步锁的计数器实现
 * <li>
 * </ul>
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class SynchronizedLockCounterImpl implements ICounter {

	/**
	 * lock
	 */
	final SynchronizedLock lock = new SynchronizedLock();

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