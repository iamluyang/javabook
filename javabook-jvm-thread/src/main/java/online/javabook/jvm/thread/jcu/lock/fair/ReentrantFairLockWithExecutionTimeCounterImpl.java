package online.javabook.jvm.thread.jcu.lock.fair;

import online.javabook.jvm.thread.sync.ICounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <ul>
 * 基于ReentrantLock计数器，这是一个在多线程环境下可靠的计数器,
 * 公平可能会带来性能问题，但不是绝对
 * <li>
 * </ul>
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class ReentrantFairLockWithExecutionTimeCounterImpl implements ICounter {

	private int executionTime;

	/**
	 * lock - 强制设为公平锁
	 */
	final Lock lock = new ReentrantLock(true);

	/**
	 *
	 * @param millis
	 */
	public ReentrantFairLockWithExecutionTimeCounterImpl(int millis) {
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