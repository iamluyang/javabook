package online.javabook.jvm.thread.type;

/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class KnifeFirstDeadLockThread extends Thread {

	/**
	 * knive
	 */
	private Knife knife;

	/**
	 * fork
	 */
	private Fork fork;

	/**
	 * @param knife
	 * @param fork
	 */
	public KnifeFirstDeadLockThread(Knife knife, Fork fork) {
		this.knife = knife;
		this.fork = fork;
	}

	@Override
	public void run() {

		for (;;) {
			synchronized (knife) {
				System.out.println(Thread.currentThread().getName() + " get knife.");

				synchronized (fork) {
					System.out.println(Thread.currentThread().getName()	+ " get fork.");

					System.out.println(Thread.currentThread().getName()	+ " is eating.");
				}
			}
		}
	}

}
