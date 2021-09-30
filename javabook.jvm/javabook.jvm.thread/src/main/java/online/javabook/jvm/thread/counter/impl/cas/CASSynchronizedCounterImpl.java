package online.javabook.jvm.thread.counter.impl.cas;

import online.javabook.jvm.thread.cas.CASSynchronizedNumber;
import online.javabook.jvm.thread.counter.api.ICounter;

/**
 * 基于CASSyncCounterImpl实现的计数器
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 * 
 */
public class CASSynchronizedCounterImpl implements ICounter {

	/**
	 * casNumber
	 */
	private CASSynchronizedNumber number = new CASSynchronizedNumber();

	@Override
	public long get() {
		return number.get();
	}

	/**
	 * @return
	 */
	public long increment() {

		for (;;) {
			int expect = number.get();
			int update = expect + 1;
			if (number.compareAndSet(expect, update))
				return update;
		}
	}

	/**
	 * @return
	 */
	public long decrement() {

		for (;;) {
			int expect = number.get();
			int update = expect - 1;
			if (number.compareAndSet(expect, update))
				return update;
		}
	}
}
