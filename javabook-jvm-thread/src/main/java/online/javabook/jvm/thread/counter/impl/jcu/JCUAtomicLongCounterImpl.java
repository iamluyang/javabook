package online.javabook.jvm.thread.counter.impl.jcu;

import online.javabook.jvm.thread.counter.api.ICounter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 基于原子类型的计数器，这是一个在多线程环境下可靠的计数器，基于compareAndSet机制的方式
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class JCUAtomicLongCounterImpl implements ICounter {

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