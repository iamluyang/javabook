package online.javabook.jvm.thread.sync;

import online.javabook.jvm.thread.jcu.lock.simple.JavaConCurrentAQSLock;

/**
 * 一个基于JCU AQS的计数器
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class JavaConCurrentAQSSLockCounterImpl implements ICounter {

	final JavaConCurrentAQSLock lock = new JavaConCurrentAQSLock();

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