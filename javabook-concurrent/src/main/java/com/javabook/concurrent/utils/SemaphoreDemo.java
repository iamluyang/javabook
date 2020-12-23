package com.javabook.concurrent.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 计算信号量用来控制同时访问某个特定资源的操作数量
 *
 * 场景：
 * 1.用于控制同时访问某些特定资源的线程数量，如有界容器
 * 2.用于限制同时执行某个指定操作的线程数量，
 *
 * 特例：
 * 二值信号量 Semaphore mutex = new Semaphore(1)
 * 将信号量初始化为 1，使得它在使用时最多只有一个可用的许可，从而可用作一个相互排斥的锁。
 *
 * @author Administrator
 *
 */
public class SemaphoreDemo {

	/**
	 * pool
	 */
	private Set<Object> set;

	/**
	 * semaphoreBound
	 */
	private final Semaphore semaphoreBound;

	/**
	 * @param maxPool
	 */
	public SemaphoreDemo(int bound) {
		this.set  = Collections.synchronizedSet( new HashSet<Object>() );
		this.semaphoreBound = new Semaphore(bound);
	}

	/**
	 * @param x
	 * @return
	 * @throws Exception
	 */
	public boolean add(Object x) throws Exception {

		// acquire仅仅表示消费一个许可，信号量不会与某个消费许可的线程关联
		// 因此可以在一个线程中获取许可，而在另外一个线程中释放许可
		semaphoreBound.acquire();
		boolean added = false;
		try {
			added = set.add(x);
			return added;
		} finally {
			if(!added)
				semaphoreBound.release();
		}
	}

	/**
	 * @param x
	 * @return
	 * @throws Exception
	 */
	public boolean remove(Object x) throws Exception {

		// release仅仅表示释放一个许可，信号量不会与某个释放许可的线程关联
		// 因此可以在一个线程中释放许可，而在另外一个线程中获取许可
		boolean removed = set.remove(x);
		if(removed) semaphoreBound.release();
		return removed;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}