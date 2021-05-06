package online.javabook.pattern.thread.readwritelock2;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public final class SimpleReadWriteLock {
	
	/**
	 * readingReaders
	 */
	private int readingReaders = 0;
	
	/**
	 * waitingWriters
	 */
	private int waitingWriters = 0;
	
	/**
	 * writingWriters
	 */
	private int writingWriters = 0;
	
	/**
	 * preferWriter
	 */
	private boolean preferWriter = true;

	// --------------------------------------------------------------------------------
	// readLock
	// --------------------------------------------------------------------------------

	/**
	 *
	 * @throws InterruptedException
	 */
	public synchronized void readLock() throws InterruptedException {
		while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
			wait();
		}
		readingReaders++;
	}

	/**
	 *
	 */
	public synchronized void readUnlock() {
		readingReaders--;
		preferWriter = true;
		notifyAll();
	}

	// --------------------------------------------------------------------------------
	// writeLock
	// --------------------------------------------------------------------------------

	/**
	 *
	 * @throws InterruptedException
	 */
	public synchronized void writeLock() throws InterruptedException {
		waitingWriters++;
		try {
			while (readingReaders > 0 || writingWriters > 0) {
				wait();
			}
		} finally {
			waitingWriters--;
		}
		writingWriters++;
	}

	/**
	 *
	 */
	public synchronized void writeUnlock() {
		writingWriters--;
		preferWriter = false;
		notifyAll();
	}
}
