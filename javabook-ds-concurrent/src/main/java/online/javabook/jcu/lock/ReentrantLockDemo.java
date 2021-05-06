package online.javabook.jcu.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * http://www.ibm.com/developerworks/cn/java/j-jtp10264/
 * 
 * 对 synchronized 的改进
 * 
 * 如此看来同步相当好了，是么？那么为什么 JSR 166 小组花了这么多时间来开发 java.util.concurrent.lock
 * 框架呢？答案很简单－同步是不错，但它并不完美。它有一些功能性的限制 ――
 * 它无法中断一个正在等候获得锁的线程，也无法通过投票得到锁，如果不想等下去，也就没法得到锁
 * 。同步还要求锁的释放只能在与获得锁所在的堆栈帧相同的堆栈帧中进行，多数情况下
 * ，这没问题（而且与异常处理交互得很好），但是，确实存在一些非块结构的锁定更合适的情况。
 * 
 * ReentrantLock 类
 * 
 * java.util.concurrent.lock 中的 Lock 框架是锁定的一个抽象，它允许把锁定的实现作为 Java
 * 类，而不是作为语言的特性来实现。这就为 Lock 的多种实现留下了空间，各种实现可能有不同的调度算法、性能特性或者锁定语义。 ReentrantLock
 * 类实现了 Lock ，它拥有与 synchronized
 * 相同的并发性和内存语义，但是添加了类似锁投票、定时锁等候和可中断锁等候的一些特性。此外，它还提供了在激烈争用情况下更佳的性能
 * 。（换句话说，当许多线程都想访问共享资源时，JVM 可以花更少的时候来调度线程，把更多时间用在执行线程上。）
 * 
 * reentrant
 * 锁意味着什么呢？简单来说，它有一个与锁相关的获取计数器，如果拥有锁的某个线程再次得到锁，那么获取计数器就加1，然后锁需要被释放两次才能获得真正释放
 * 。这模仿了 synchronized 的语义；如果线程进入由线程已经拥有的监控器保护的 synchronized
 * 块，就允许线程继续进行，当线程退出第二个（或者后续） synchronized 块的时候，不释放锁，只有线程退出它进入的监控器保护的第一个
 * synchronized 块时，才释放锁。
 * 
 * 重要方法 lock public void lock()获取锁。 
 * 锁的进入 -- 如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为 1。 
 * 锁的重入 -- 如果当前线程已经保持该锁，则将保持计数加 1，并且该方法立即返回。 
 * 锁的禁用 -- 如果该锁被另一个线程保持，则出于线程调度的目的，禁用当前线程，并且在获得锁之前，该线程将一直处于休眠状态，此时锁保持计数被设置为 1。
 * 
 * lockInterruptibly public void lockInterruptibly() throws
 * 
 * InterruptedException如果当前线程未被中断，则获取锁。 
 * 锁的进入 -- 如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为 1。
 * 锁的重入 -- 如果当前线程已经保持此锁，则将保持计数加 1，并且该方法立即返回。
 * 锁的禁用 -- 如果锁被另一个线程保持，则出于线程调度目的，禁用当前线程，
 * 并且在发生以下两种情况之一以前，该线程将一直处于休眠状态：
 * 锁由当前线程获得；
 * 或者 其他某个线程中断当前线程。 如果当前线程获得该锁，则将锁保持计数设置为 1。
 * 
 * 其他：
 * before/after模式
 * 
 * @author LuYang
 * 
 */
public class ReentrantLockDemo {

	/**
	 * lock
	 */
	final Lock lock = new ReentrantLock();

	/**
	 * notFull
	 */
	final Condition notFull = lock.newCondition();

	/**
	 * notEmpty
	 */
	final Condition notEmpty = lock.newCondition();

	/**
	 * items
	 */
	final Object[] items = new Object[100];

	/**
	 * putIndex
	 */
	int putIndex;

	/**
	 * takeIndex
	 */
	int takeIndex;

	/**
	 * count
	 */
	int count;

	/**
	 * @param object
	 * @throws InterruptedException
	 */
	public void put(Object object) throws InterruptedException {

		lock.lock();
		try {
			while (count == items.length)
				notFull.await();

			items[putIndex] = object;
			if (++putIndex == items.length)
				putIndex = 0;

			++count;
			notEmpty.signal();

		} finally {
			lock.unlock();
		}
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public Object take() throws InterruptedException {

		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();

			Object x = items[takeIndex];

			if (++takeIndex == items.length)
				takeIndex = 0;

			--count;
			notFull.signal();

			return x;
		} finally {
			lock.unlock();
		}
	}

}
