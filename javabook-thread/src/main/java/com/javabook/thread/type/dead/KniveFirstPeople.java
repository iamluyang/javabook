package com.javabook.thread.type.dead;

/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-22
 *
 */
public class KniveFirstPeople extends Thread {

	/**
	 * knive
	 */
	private Object knive;

	/**
	 * fork
	 */
	private Object fork;

	/**
	 * @param knive
	 * @param fork
	 */
	public KniveFirstPeople(Knive knive, Fork fork) {
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
