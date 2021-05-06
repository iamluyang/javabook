package online.javabook.jvm.thread.counter.impl.jcu;

import online.javabook.jvm.thread.counter.api.ICounter;

/**
 * 一个基于JCU AQS的计数器
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class JCUAQSLockCounterImpl implements ICounter {

	final JCUAQSLock lock = new JCUAQSLock();

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