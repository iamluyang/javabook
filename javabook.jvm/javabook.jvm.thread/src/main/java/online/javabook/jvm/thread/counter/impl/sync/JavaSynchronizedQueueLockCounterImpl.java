package online.javabook.jvm.thread.counter.impl.sync;

import online.javabook.jvm.thread.counter.api.ICounter;

/**
 * 基于一个队列实现的锁来实现线程安全的计数器
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class JavaSynchronizedQueueLockCounterImpl implements ICounter {

	/**
	 * lock
	 */
	final JavaSynchronizedQueueLock lock = new JavaSynchronizedQueueLock();

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