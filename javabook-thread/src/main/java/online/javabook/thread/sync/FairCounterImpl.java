package online.javabook.thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <ul>
 * 基于ReentrantLock计数器，这是一个在多线程环境下可靠的计数器
 * <li>公平给性能带来问题
 * </ul>
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class FairCounterImpl implements ICounter {

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