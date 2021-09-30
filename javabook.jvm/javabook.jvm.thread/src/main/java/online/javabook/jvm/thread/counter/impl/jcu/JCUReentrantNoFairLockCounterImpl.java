package online.javabook.jvm.thread.counter.impl.jcu;

import online.javabook.jvm.thread.counter.api.ICounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于ReentrantLock计数器，你可以拥有与synchronized语义同样的线程同步，但得到更好的性能
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class JCUReentrantNoFairLockCounterImpl implements ICounter {

	/**
	 * lock - 默认为不公平锁
	 */
	final Lock lock = new ReentrantLock();

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