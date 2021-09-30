package online.javabook.jcu.queue.blocking;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

/**
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2018年7月19日
 *
 */
public class LinkedBlockingQueueMain {
	static Random random = new Random();

	public static void main(String[] args) {

		// message queue 这是一个有界队列
		BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);

		// 生产者向queue中创建messageId
		Thread producerThread = new Thread(() -> {
			while (true) {
				try {
					// put方法会在队列已满时被阻塞
					String messageId = UUID.randomUUID().toString();
					queue.put(messageId);
					System.out.println("P:----------> This messageId is created [" + messageId + "] by " + Thread.currentThread());
					// 创建一个慢的生产者和两个快的消费者
					doSleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		producerThread.setName("producerThread");

		// 消费者1消费queue中的messageId
		Thread consumerThread1 = new Thread(() -> {
			while (true ) {
				try {
					// take方法会在队列已空时被阻塞，直到有数据可以出列
					String messageId = queue.take();
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
					String messageId = queue.take();
					System.out.println("C:<---------- This messageId is take [" + messageId + "] by " + Thread.currentThread());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		consumerThread2.setName("consumerThread2");

		producerThread.start();
		consumerThread1.start();
		consumerThread2.start();
	}

	private static void doSleep(int milles){

		try {
			Thread.sleep(random.nextInt(milles));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
