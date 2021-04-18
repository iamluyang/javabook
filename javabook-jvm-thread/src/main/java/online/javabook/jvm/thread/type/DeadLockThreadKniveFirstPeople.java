package online.javabook.jvm.thread.type;

/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class DeadLockThreadKniveFirstPeople extends Thread {

	/**
	 * knive
	 */
	private Knive knive;

	/**
	 * fork
	 */
	private Fork fork;

	/**
	 * @param knive
	 * @param fork
	 */
	public DeadLockThreadKniveFirstPeople(Knive knive, Fork fork) {
		this.knive = knive;
		this.fork = fork;
	}

	@Override
	public void run() {

		for (;;) {
			synchronized (knive) {
				System.out.println(Thread.currentThread().getName()
						+ "- get knive.");

				synchronized (fork) {
					System.out.println(Thread.currentThread().getName()
							+ "- get fork.");

					System.out.println(Thread.currentThread().getName()
							+ "-eatting.");
				}
			}
		}
	}

}
