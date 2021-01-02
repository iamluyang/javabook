package online.javabook.jvm.thread.type.dead;

/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class ForkAndKniveDeadLockMain {

	public static void main(String[] args) throws InterruptedException {

		// fork
		Fork fork = new Fork();

		// knive
		Knive knive = new Knive();

		// people1
		Thread people1 = new ForkFirstPeople(fork, knive);

		// people2
		Thread people2 = new KniveFirstPeople(knive, fork);

		people1.setName("DeadLockThread-People1");
		people2.setName("DeadLockThread-People2");

		// deadlock
		people1.start();
		people2.start();
	}
}
