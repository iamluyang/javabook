package online.javabook.jvm.thread.type;

/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class ForkFirstDeadLockThread extends Thread {

	/**
	 * fork
	 */
	private Fork fork;

	/**
	 * knive
	 */
	private Knife knife;

	public ForkFirstDeadLockThread(Fork fork, Knife knife) {
		this.fork = fork;
		this.knife = knife;
	}

	@Override
	public void run() {

		for (;;) {
			synchronized (fork) {
				System.out.println(Thread.currentThread().getName()	+ " get fork.");

				synchronized (knife) {
					System.out.println(Thread.currentThread().getName()	+ " get knife.");

					System.out.println(Thread.currentThread().getName() + "is eating.");
				}
			}
		}
	}
}
