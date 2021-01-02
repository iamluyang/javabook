package online.javabook.jvm.thread.sync;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <ul>
 * 基于原子类型的计数器，这是一个在多线程环境下可靠的计数器
 * <li>基于compareAndSet机制的方式
 * </ul>
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class AtomicCounterImpl implements ICounter {

	/**
	 * value
	 */
	AtomicLong value = new AtomicLong();

	@Override
	public long get() {
		return value.get();
	}

	@Override
	public long increment() {
		return value.incrementAndGet();
	}

	@Override
	public long decrement() {
		return value.decrementAndGet();
	}
}