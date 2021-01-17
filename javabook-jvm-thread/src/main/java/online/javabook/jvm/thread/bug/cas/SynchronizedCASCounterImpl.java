package online.javabook.jvm.thread.bug.cas;

import online.javabook.jvm.thread.bug.cas.SynchronizedCASNumber;
import online.javabook.jvm.thread.sync.ICounter;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 * 
 */
public class SynchronizedCASCounterImpl implements ICounter {

	/**
	 * casNumber
	 */
	private SynchronizedCASNumber number = new SynchronizedCASNumber();

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
