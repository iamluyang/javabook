package com.javabook.thread.bug.aba;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 什么是ABA问题：
 * 
 * 先来看一个多线程的运行场景：
 * 
 * 时间点1 ： 线程1查询值是否为A 时间点2 ：线程2查询值是否为A 时间点3 ：线程2比较并更新值为B 时间点4 ：线程2查询值是否为B 时间点5
 * ：线程2比较并更新值为A 时间点6 ：线程1比较更新值为C
 * 
 * 在2个线程交替执行的过程中，线程1在时间点6的时候依然能够正常的进行CAS操作，尽管在时间点2到时间点6期间已经发生一些意想不到的变化，
 * 但是线程1对这些变化却一无所知，因为对线程1来说A的确还在。通常将这类现象称为ABA问题。
 * 
 * 解决ABA问题的初步思路： 我们先来思考一下ABA问题的根源是什么，当线程进行CAS操作时是通过比较值的方式来判断是否能够更改当前的值。
 * 但有些业务场景仅仅依靠比较值是不够的，可能还需要知道这个值是被谁更新了，更新了多少次，更新的时间等等。
 * 那么我们可以给每个值再关联上一些扩展数据作为额外的比较机制，从而形成一个值与一个或若干标记值的复合类型。
 * 
 * 解决ABA问题的技术细节： 我们现在有了基本了解决思路，但还需要考虑一些实现上的细节。CAS操作由原先仅仅对一个值的比较现在变成了对
 * 多个值的比较，而在多线程环境中同时操作多个值往往比操作对一个值更加需要小心谨慎，需要以原子的方式更新多 个值才能保证在多线程环境不出现意想不到的赋值操作。
 * 
 * 并发包如何解决ABA问题：
 * JDK的并发包中提供了AtomicStampedReference和AtomicMarkableReference类型来解决可能发生的ABA问题。
 * 
 * ABA问题的技术小结： 1.ABA并非是一个错误，而是多个线程在交替执行过程中可能发生的现象，并且这个现象仅仅通过基本的CAS算法是难以察觉的。是否
 * 需要处理这个问题取决与你的业务场景。 2.根据我们之前提及的“解决ABA问题的初步思路”
 * 以及JDK的并发包中的AtomicStampedReference和AtomicMarkableReference
 * 类型的实现代码，我们还可以扩展出适合自身业务需求解决ABA问题的新的原子类型，比如以线程id作为标记，以当前时间作为标记等等。
 * 现在你是否觉得思路豁然开朗。
 * 
 * @author LuYang
 */
public class DontCheckABAMain {

	/**
	 * 把邮件内容“远方的问候”放到了一个普通信封envelope里 envelope = 邮件内容
	 */
	static AtomicReference<String> envelope = new AtomicReference<String>(
			"远方的来信");

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// 线程1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				String mailContent = envelope.get();

				System.out
						.println("T1首先看到了信封里的邮件内容[ " + mailContent + " ]（A）。");

				try {
					// T1实际上被强制sleep一会，好让T2这个时候有机可乘
					System.out.println("T1现在有事情暂时的离开了一小会。");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				boolean result = envelope.compareAndSet(mailContent, "远方的回信");
				if (result) {
					System.out.println("\nT1在返回后重新检查了邮件，好像没人动过。" + "现在可以写回信了[ "
							+ envelope.get() + " ]。");
				}
			}
		});

		// 线程2
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					// T2先sleep一会，好让T1有机会先看到信封里面的邮件内容
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				String mailContent = envelope.get();

				// T2第一次修改了信封里的邮件内容
				boolean firstOpt = envelope.compareAndSet(mailContent, "");
				if (firstOpt)
					System.out.println("\nT2悄悄将信封里的邮件内容[ " + mailContent
							+ " ]取走（B）。" + "现在邮件内容已经不再信封里了。");

				// T2第二次修改了信封里的邮件内容
				boolean secondOpt = envelope.compareAndSet("", mailContent);
				if (secondOpt)
					System.out.println("T2悄悄把信封里的邮件内容[ " + envelope.get()
							+ " ]放回（A）。" + "现在邮件内容好像没被动过一样。");
			}
		});

		t1.start();
		t2.start();
	}
}
