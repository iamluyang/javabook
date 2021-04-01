package online.javabook.jvm.thread.jcu.lock.fair;

import online.javabook.jvm.thread.sync.ICounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <ul>
 * 基于ReentrantLock计数器，这是一个在多线程环境下可靠的计数器
 * </ul>
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class ReentrantNoFairLockWithExecutionTimeCounterImpl implements ICounter {

	/**
	 * executionTime
	 */
	private int executionTime;

	/**
	 * lock - 默认为不公平锁
	 */
	final Lock lock = new ReentrantLock();

	/**
	 *
	 * @param millis
	 */
	public ReentrantNoFairLockWithExecutionTimeCounterImpl(int millis) {
		this.executionTime = millis;
	}

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
			slowly();
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
			slowly();
			return value;
		} finally {
			lock.unlock();
		}
	}

	/**
	 *
	 */
	private void slowly() {
		try {
			Thread.sleep(executionTime);
		} catch (InterruptedException e) {
		}
	}
}