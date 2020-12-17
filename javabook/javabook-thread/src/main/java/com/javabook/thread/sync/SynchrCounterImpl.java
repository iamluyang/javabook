package com.javabook.thread.sync;

/**
 * <ul>
 * 基于线程同步的计数器，这是一个在多线程环境下可靠的计数器
 * <li>同步机制让性能略有损耗，但毕竟保障了线程安全
 * </ul>
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class SynchrCounterImpl implements ICounter {

	/**
	 * value
	 */
	private long value = 0;

	@Override
	public synchronized long get() {
		return value;
	}

	@Override
	public synchronized long increment() {
		return value++;
	}

	@Override
	public synchronized long decrement() {
		return value--;
	}
}