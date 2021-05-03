package online.javabook.jvm.thread.lock.reentrantlock.sync;

/**
 * synchronized的可重入性
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class SynchronizedReentrantLockMain {

	/**
	 *
	 * @return
	 */
	public synchronized void firstSynchronizedBlock() {
		System.out.println("Enter the first sync block: " + Thread.currentThread().getName());

		secondSynchronizedBlock();
		System.out.println("Leave the second sync block: " + Thread.currentThread().getName());
	}

	public synchronized void secondSynchronizedBlock() {
		System.out.println("Enter the second sync block" + Thread.currentThread().getName());
	}

	public static void main(String[] args) {

		SynchronizedReentrantLockMain main = new SynchronizedReentrantLockMain();

		main.firstSynchronizedBlock();
		System.out.println("Leave the first sync block: " + Thread.currentThread().getName());
	}
}