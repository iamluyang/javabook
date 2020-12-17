package com.javabook.thread.bug.cas;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 * 
 */
public class SynchroCASCounter {

	/**
	 * casNumber
	 */
	private SynchroCAS number = new SynchroCAS();

	/**
	 * @return
	 */
	public int increment() {

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
	public int decrement() {

		for (;;) {
			int expect = number.get();
			int update = expect - 1;
			if (number.compareAndSet(expect, update))
				return update;
		}
	}
}
