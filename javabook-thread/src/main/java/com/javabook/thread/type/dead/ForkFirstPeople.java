package com.javabook.thread.type.dead;

/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-22
 *
 */
public class ForkFirstPeople extends Thread {

	/**
	 * fork
	 */
	private Fork fork;

	/**
	 * knive
	 */
	private Knive knive;

	public ForkFirstPeople(Fork fork, Knive knive) {
		this.fork = fork;
		this.knive = knive;
	}

	@Override
	public void run() {

		for (;;) {
			synchronized (fork) {
				System.out.println(Thread.currentThread().getName()
						+ "- get fork.");

				synchronized (knive) {
					System.out.println(Thread.currentThread().getName()
							+ "- get knive.");

					System.out.println(Thread.currentThread().getName()
							+ "- eatting.");
				}
			}
		}
	}

}
