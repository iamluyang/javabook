package online.javabook.thread.bug.aba;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * 说明：AtomicMarkableReference可以以原子的方式同时维护一对值 通过构造函数传递一个引用对象，一个boolean
 * 
 * AtomicStampedReference和AtomicStampedReference类似， 区别：
 * AtomicMarkableReference的标记值是一个整数值，可以选择状态范围更大
 * AtomicStampedReference的标记值是一个布尔值，只能设置两种标记状态
 * 
 * @author LuYang
 * 
 */
public final class AtomicMarkableReferenceDemo {

	/**
	 * 把邮件内容“远方的问候”放到了一个智能的能够记录操作标记的信封envelope中 envelope = 邮件内容 + 操作标记
	 */
	static AtomicMarkableReference<String> envelope = new AtomicMarkableReference<String>(
			"远方的来信", false);

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				boolean[] markHolder = new boolean[1];
				String mailContent = envelope.get(markHolder);

				System.out.println("T1首先看到了信封里的邮件[ " + mailContent
						+ " ]（A），信封上还有一个操作标记：" + markHolder[0]);

				try {
					// T1实际上被强制sleep一会，好让T2这个时候有机可乘
					System.out.println("T1现在有事情暂时的离开了");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// T1尝试给‘远方的来信’回信
				boolean result = envelope.compareAndSet(mailContent, "远方的回信",
						markHolder[0], !markHolder[0]);

				if (result) {
					System.out.println("\nT1在返回后检查邮件内容和信封上面的操作标记。"
							+ "邮件内容还是一样。信封的操作标记也没人动过。" + "现在可以写回信了[ "
							+ envelope.getReference() + "]");

				} else {
					System.out.println("\nT1在返回后检查邮件内容和信封上面的操作标记。"
							+ "邮件内容还是一样，但信封的操作标记被动过了。\n"
							+ "T1：信件被别人偷看了，我该做点什么好呢。\n" + "或者\n "
							+ "T1：信件被别人偷看了，这没什么大不了的。");

				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					// T2先sleep一会，好让T1有机会先看到信封里面的邮件内容
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				boolean[] markHolder = new boolean[1];
				String mailContent = envelope.get(markHolder);

				// T2第一次修改了信封里的邮件内容和信封上的操作标记
				boolean firstOpt = envelope.compareAndSet(mailContent, "",
						markHolder[0], !markHolder[0]);
				if (firstOpt)
					System.out.println("\nT2悄悄将信封里的邮件内容[ " + mailContent
							+ " ]取走（B）。" + "现在邮件内容已经不再信封里了。"
							+ "信封上的操作标记首次被改动了：" + envelope.isMarked());

				// T2第二次修改了信封里的邮件内容和信封上的操作标记
				boolean secondOpt = envelope.compareAndSet("", mailContent,
						markHolder[0], !markHolder[0]);
				if (secondOpt)
					System.out.println("T2悄悄把信封里的邮件内容[ "
							+ envelope.getReference() + " ]放回（A）。"
							+ "现在邮件内容好像没被动过一样。" + "信封上的操作标记再次被改动了："
							+ envelope.isMarked());

			}
		});

		t1.start();
		t2.start();
	}
}
