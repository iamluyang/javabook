package online.javabook.jvm.thread.jcu.lock.fair;

import online.javabook.jvm.thread.sync.ICounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <ul>
 * 基于ReentrantLock的公平锁，并且可以设置一个可控的执行延迟参数
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

	private int number;

	/**
	 * lock - 强制设为公平锁
	 */
	final Lock lock = new ReentrantLock(true);

	/**
	 *
	 * @param number
	 */
	public ReentrantFairLockWithExecutionTimeCounterImpl(int number) {
		this.number = number;
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
		double y=1.0;
		for(int i=0;i<=number;i++){
			double π=3*Math.pow(2, i)*y;
			y=Math.sqrt(2-Math.sqrt(4-y*y));
		}
	}
}