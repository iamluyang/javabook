package online.javabook.jcu.queue.synchronous;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2018年7月19日
 *
 */
public class SynchronousQueueMain {

	public static void main(String[] args) throws InterruptedException {

		Random random = new Random();
		BlockingQueue<String> queue = new SynchronousQueue();

		// Ping Thread
		Thread producerThread = new Thread(() -> {
			while (true ) {
				try {
					queue.put("Ping message from " + Thread.currentThread().getName());
					System.out.println("Send Ping " + Thread.currentThread().getName());

					String messageId = queue.take();
					System.out.println( Thread.currentThread().getName() + " <- " + "Receive " + messageId);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		producerThread.setName("PingThread");

		// Pang Thread
		Thread consumerThread = new Thread(() -> {
			while (true ) {
				try {
					String messageId = queue.take();
					System.out.println( Thread.currentThread().getName() + " -> " + "Receive " + messageId);

					queue.put("Pang message from " + Thread.currentThread().getName());
					System.out.println("Send Pang " + " " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		consumerThread.setName("PangThread");

		producerThread.start();
		consumerThread.start();
	}
}
