package online.javabook.jvm.thread.type.waiting;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class WaitingThread extends Thread {

	/**
	 * lock
	 */
	private Object lock = new Object();

	@Override
	public void run() {
		try {
			synchronized (lock) {
				lock.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
