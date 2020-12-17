package com.javabook.thread.sync;

/**
 * <ul>
 * <li>没有任何技术保障的实现，这是一个在多线程环境下不可靠的计数器
 * </ul>
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class UnsafeCounterImpl implements ICounter {

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
		return value++;
	}

	@Override
	public long decrement() {
		return value--;
	}
}