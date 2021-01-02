package online.javabook.jvm.thread.type;

import online.javabook.jvm.thread.type.daemon.DaemonThread;
import online.javabook.jvm.thread.type.dead.Fork;
import online.javabook.jvm.thread.type.dead.ForkFirstPeople;
import online.javabook.jvm.thread.type.dead.Knive;
import online.javabook.jvm.thread.type.dead.KniveFirstPeople;
import online.javabook.jvm.thread.type.running.RunningThread;
import online.javabook.jvm.thread.type.sleeping.SleepingThread;
import online.javabook.jvm.thread.type.waiting.WaitingThread;

/**
 * Java VisualVM 1-使用时间线视图根据图形来观察线程的执行状态 2-使用表视图来排序所感兴趣的线程 3-使用详细信息视图来显示具体线程
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class ThreadTypeMain {

	public static void main(String[] args) throws InterruptedException {

		// fork
		Fork fork = new Fork();

		// knive
		Knive knive = new Knive();

		// runnning
		Thread runnning = new RunningThread();

		// sleeping
		Thread sleeping = new SleepingThread();

		// waiting
		Thread waitting = new WaitingThread();

		// daemon
		Thread daemon = new DaemonThread();

		// dpeople1
		Thread dpeople1 = new ForkFirstPeople(fork, knive);

		// dpeople2
		Thread dpeople2 = new KniveFirstPeople(knive, fork);

		runnning.setName("My-runnning Thread");
		sleeping.setName("My-sleeping Thread");
		waitting.setName("My-waitting Thread");
		daemon.setName("My-daemon Thread");
		dpeople1.setName("My-deadlock People1");
		dpeople2.setName("My-deadlock People2");

		// runnning
		runnning.start();

		// sleeping
		sleeping.start();

		// waitting
		waitting.start();

		// daemon
		daemon.start();

		// deadlock
		dpeople1.start();
		dpeople2.start();

		Thread.sleep(600);
	}
}
