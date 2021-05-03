package online.javabook.jvm.thread.lock.reentrantlock.jcu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的可重入性
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class JcuReentrantLockMain {

	private final Lock lock = new ReentrantLock();

	/**
	 *
	 * @return
	 */
	public void firstLockedBlock() {

		lock.lock();
		try {
			System.out.println("Enter the first locked block:" + Thread.currentThread().getName());

			// Reentrant
			secondLockedBlock();
		} finally {
			lock.unlock();
			System.out.println("Leave the first locked block:" + Thread.currentThread().getName());
		}
	}

	public void secondLockedBlock() {

		lock.lock();
		try {
			System.out.println("Enter the second locked block:" + Thread.currentThread().getName());
		} finally {
			lock.unlock();
			System.out.println("Leave the second locked block:" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		JcuReentrantLockMain main = new JcuReentrantLockMain();
		main.firstLockedBlock();
	}
}