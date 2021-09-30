package online.javabook.jvm.thread.counter.impl.jcu;

import online.javabook.jvm.thread.counter.api.ICounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 基于ReentrantLock计数器，这是一个在多线程环境下可靠的计数器，公平可能带来性能损失，但也并非绝对
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class JCUReentrantFairLockCounterImpl implements ICounter {

	/**
	 * lock - 强制设为公平锁
	 */
	final Lock lock = new ReentrantLock(true);

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