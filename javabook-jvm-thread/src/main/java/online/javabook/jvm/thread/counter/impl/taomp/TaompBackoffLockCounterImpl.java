package online.javabook.jvm.thread.counter.impl.taomp;

import online.javabook.jvm.thread.counter.api.ICounter;

import java.util.concurrent.locks.Lock;

/**
 * 一个基于JCU AQS的计数器
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class TaompBackoffLockCounterImpl implements ICounter {

	final Lock lock = new TaompBackoffLock();

	/**
	 * value
	 */
	private long value = 0;

	@Override
	public long get() {
		return value;
	}

	@Override
	public long increment() {
		lock.lock();
		try {
			value++;
			return value;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public long decrement() {
		lock.lock();
		try {
			value--;
			return value;
		} finally {
			lock.unlock();
		}
	}
}