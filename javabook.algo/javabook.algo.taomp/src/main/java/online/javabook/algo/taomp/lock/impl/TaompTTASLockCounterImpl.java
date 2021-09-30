package online.javabook.algo.taomp.lock.impl;

import online.javabook.algo.taomp.lock.api.ICounter;

import java.util.concurrent.locks.Lock;

/**
 * 一个基于JCU AQS的计数器
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class TaompTTASLockCounterImpl implements ICounter {

	final Lock lock = new TaompTTASLock();

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