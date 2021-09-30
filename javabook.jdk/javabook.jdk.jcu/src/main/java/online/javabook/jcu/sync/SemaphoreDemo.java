package online.javabook.jcu.sync;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

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

	// 定义一个信号量(模拟三个收银台)
	static Semaphore checkoutCounters = new Semaphore(3);

	public static void main(String[] args) {

		// 模拟多个客户去付款
		for(int i=1; i<=10; i++) {
			new Consumer(checkoutCounters, "Consumer"+i).start();
		}
	}
}

class Consumer extends Thread {

	private Semaphore checkoutCounters;
	private String name;

	public Consumer(Semaphore checkoutCounters, String name) {
		this.checkoutCounters = checkoutCounters;
		this.name = name;
	}
	@Override
	public void run() {
		try {
			checkoutCounters.acquire();
			System.out.println(name+":进入收银台，获取了一个许可，剩余" + checkoutCounters.availablePermits() + "个许可.");
			TimeUnit.SECONDS.sleep(3);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}finally {
			System.out.println(name+":离开收银台，释放了一个许可，剩余" + checkoutCounters.availablePermits() + "个许可.");
			checkoutCounters.release();

		}
	}
}