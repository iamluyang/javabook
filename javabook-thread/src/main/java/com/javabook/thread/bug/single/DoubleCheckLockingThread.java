package com.javabook.thread.bug.single;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class DoubleCheckLockingThread extends Thread {
	
	DoubleCheckLockingInstance instance;
	
	@Override
	public void run() {
		while(true) {
			instance = DoubleCheckLockingInstance.getInstance();
			System.out.println(instance);
		}
	}
}
