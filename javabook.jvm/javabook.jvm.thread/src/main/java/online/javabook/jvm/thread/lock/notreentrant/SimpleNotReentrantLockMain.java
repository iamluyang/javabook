package online.javabook.jvm.thread.lock.notreentrant;

/**
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-27
 *
 */
public final class SimpleNotReentrantLockMain {

	private final SimpleNotReentrantLock lock = new SimpleNotReentrantLock();

	/**
	 *
	 * @return
	 */
	public void firstLockedBlock() throws InterruptedException {

		lock.lock();
		try {
			System.out.println(Thread.currentThread() + " 进入第1个同步块");

			// Reentrant
			secondLockedBlock();
		} finally {
			lock.unlock();
			System.out.println(Thread.currentThread() + " 离开第1个同步块");
		}
	}

	public void secondLockedBlock() throws InterruptedException {

		lock.lock();
		try {
			System.out.println(Thread.currentThread() + " 进入第2个同步块");
		} finally {
			lock.unlock();
			System.out.println(Thread.currentThread() + " 离开第2个同步块");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SimpleNotReentrantLockMain main = new SimpleNotReentrantLockMain();
		main.firstLockedBlock();
	}
}