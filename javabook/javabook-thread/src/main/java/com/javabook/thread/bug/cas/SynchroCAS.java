package com.javabook.thread.bug.cas;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class SynchroCAS {

	/**
	 * value
	 */
	private int value;

	/**
	 * @return
	 */
	public synchronized int get() {
		return value;
	}

	/**
	 * @param expect
	 * @param update
	 * @return
	 */
	public synchronized boolean compareAndSet(int expect, int update) {

		if (value == expect) {
			value = update;
			return true;
		} else {
			return false;
		}
	}
}
