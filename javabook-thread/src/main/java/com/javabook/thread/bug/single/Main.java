package com.javabook.thread.bug.single;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		// doubleCheckLockingThread
		DoubleCheckLockingThread doubleCheckLockingThread1 = new DoubleCheckLockingThread();
		DoubleCheckLockingThread doubleCheckLockingThread2 = new DoubleCheckLockingThread();
		
		doubleCheckLockingThread1.start();
		doubleCheckLockingThread2.start();
	}
}
