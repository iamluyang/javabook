package online.javabook.jvm.thread.sync;

/**
 * <ul>
 * 基于volatile计数器，这是一个在多线程环境下不可靠的计数器
 * <li>volatile提供了JVM内存模型中的可见性
 * <li>volatile并不具备在多线程环境下资源的共享与互斥的安全性
 * </ul>
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class UnsafeVolatileCounterImpl implements ICounter {

	/**
	 * value
	 */
	private volatile long value = 0;

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