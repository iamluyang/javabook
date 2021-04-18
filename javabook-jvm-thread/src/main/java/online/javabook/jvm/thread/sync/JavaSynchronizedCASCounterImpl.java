package online.javabook.jvm.thread.sync;

import online.javabook.jvm.thread.bug.cas.JavaSynchronizedCASNumber;

/**
 * 基于SynchronizedCASNumber实现的计数器
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 * 
 */
public class JavaSynchronizedCASCounterImpl implements ICounter {

	/**
	 * casNumber
	 */
	private JavaSynchronizedCASNumber number = new JavaSynchronizedCASNumber();

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
