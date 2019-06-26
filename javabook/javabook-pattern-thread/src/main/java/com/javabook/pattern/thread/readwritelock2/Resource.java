package com.javabook.pattern.thread.readwritelock2;


/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015年7月19日
 *
 */
public class Resource {
	
	/**
	 * buffer
	 */
	private final char[] buffer;

	/**
	 * lock
	 */
	private final ReadWriteLock lock = new ReadWriteLock();

	/**
	 * @param size
	 */
	public Resource(int size) {
		this.buffer = new char[size];
		for (int index = 0; index < buffer.length; index++) {
			buffer[index] = '*';
		}
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public char[] read() throws InterruptedException {
		lock.readLock();
		try {
			return doRead();
		} finally {
			lock.readUnlock();
		}	
	}

	/**
	 * @return
	 */
	private char[] doRead() {
		char[] newbuf = new char[buffer.length];
		for (int i = 0; i < buffer.length; i++) {
			newbuf[i] = buffer[i];
		}
		slowly();
		return newbuf;
	}

	/**
	 * @param c
	 * @throws InterruptedException
	 */
	public void write(char c) throws InterruptedException {
		lock.writeLock();
		try {
			doWrite(c);
		} finally {
			lock.writeUnlock();
		}
	}

	/**
	 * @param c
	 */
	private void doWrite(char c) {
		for (int index = 0; index < buffer.length; index++) {
			buffer[index] = c;
			slowly();
		}
	}

	/**
	 * 
	 */
	private void slowly() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
	}
}
