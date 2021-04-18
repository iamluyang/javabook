package online.javabook.jvm.thread.sync;

/**
 * 这是一个在多线程环境下不可靠的计数器
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class UnsafeThreadCounterImpl implements ICounter {

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