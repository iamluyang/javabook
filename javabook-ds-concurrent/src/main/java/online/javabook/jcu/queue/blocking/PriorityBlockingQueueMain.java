package online.javabook.jcu.queue.blocking;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2018年7月19日
 *
 */
public class PriorityBlockingQueueMain {

	public static void main(String[] args) throws InterruptedException {

		Random random = new Random();
		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue();

		// 生产者向queue中创建messageId
		Thread producerThread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				int messageId = random.nextInt(1000);
				queue.put(messageId);
				System.out.println("P:----------> This messageId is created [" + messageId + "] by " + Thread.currentThread());
			}
		});
		producerThread.setName("producerThread");

		// 消费者1消费queue中的messageId
		Thread consumerThread1 = new Thread(() -> {
			while (true ) {
				try {
					// take方法会在队列已空时被阻塞，直到有数据可以出列
					int messageId = queue.take();
					System.out.println("C:<---------- This messageId is take [" + messageId + "] by " + Thread.currentThread());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		consumerThread1.setName("consumerThread1");

		// 消费者2消费queue中的messageId
		Thread consumerThread2 = new Thread(() -> {
			while (true ) {
				try {
					// take方法会在队列已空时被阻塞，直到有数据可以出列，不会抛出空队列异常
					int messageId = queue.take();
					System.out.println("C:<---------- This messageId is take [" + messageId + "] by " + Thread.currentThread());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		consumerThread2.setName("consumerThread2");

		producerThread.start();
		producerThread.join();

		consumerThread1.start();
		consumerThread2.start();
	}
}
