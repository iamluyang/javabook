package online.javabook.jvm.thread.counter.impl.cas;

import online.javabook.jvm.thread.cas.CASUnSafeNumber;
import online.javabook.jvm.thread.counter.api.ICounter;

/**
 * 基于Unsafe的compareAndSwapInt实现的计数器
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class CASUnsafeCounterImpl implements ICounter {

	/**
	 * casNumber
	 */
	private CASUnSafeNumber number = new CASUnSafeNumber();

	@Override
	public long get() {
		return number.get();
	}

	/**
	 * @return
	 */
	public long increment() {

		for (;;) {
			long expect = number.get();
			long update = expect + 1;
			if (number.compareAndSet(expect, update))
				return update;
		}
	}

	/**
	 * @return
	 */
	public long decrement() {

		for (;;) {
			long expect = number.get();
			long update = expect - 1;
			if (number.compareAndSet(expect, update))
				return update;
		}
	}

}
