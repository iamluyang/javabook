package online.javabook.jvm.thread.aba;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * <ul>
 * <li>1.ABA并非一定是一个错误，而是一种多个线程在交替执行过程中可能发生的现象。
 * AtomicStampedReference提供了一种机制能够发现是否发生了ABA，从而决定是否要处理这种情况。
 * 
 * <li>2.代码中通过Thread.sleep来切换线程的执行顺序，加大ABA的几率，否则该现象将会随机发生。
 * </ul>
 * 
 * @author LuYang
 */
public final class CheckABAMain {

	/**
	 * 把邮件内容“远方的问候”放到了一个智能的能够记录操作标记的信封envelope中 envelope = 邮件内容 + 操作标记
	 */
	static AtomicStampedReference<String> envelope = new AtomicStampedReference<String>(
			"远方的来信", 0);

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// 线程1
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				String mailContent = envelope.getReference();
				int mailStamp = envelope.getStamp();

				System.out.println("T1首先看到了信封里的邮件内容[ " + mailContent + " ]（A）。"
						+ "信封上还有一个操作标记：" + mailStamp);

				try {
					// T1实际上被强制sleep一会，好让T2这个时候有机可乘
					System.out.println("T1现在有事情暂时的离开了");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// T1尝试给‘远方的来信’回信
				boolean result = envelope.compareAndSet(mailContent, "远方的回信",
						mailStamp, ++mailStamp);

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

				int[] mailStamp = new int[1];
				String mailContent = envelope.get(mailStamp);

				// T2第一次修改了信封里的邮件内容和信封上的操作标记
				boolean firstOpt = envelope.compareAndSet(mailContent, "",
						mailStamp[0], ++mailStamp[0]);
				if (firstOpt)
					System.out.println("\nT2悄悄将信封里的邮件内容[ " + mailContent
							+ " ]取走（B）。" + "现在邮件内容已经不在信封里了。"
							+ "信封上的操作标记首次被改动了：" + envelope.getStamp());

				// T2第二次修改了信封里的邮件内容和信封上的操作标记
				boolean secondOpt = envelope.compareAndSet("", mailContent,
						mailStamp[0], ++mailStamp[0]);
				if (secondOpt)
					System.out.println("T2悄悄把信封里的邮件内容[ "
							+ envelope.getReference() + " ]放回（A）。"
							+ "现在邮件内容好像没被动过一样。" + "信封上的操作标记再次被改动了："
							+ envelope.getStamp());
			}
		});

		t1.start();
		t2.start();
	}
}
