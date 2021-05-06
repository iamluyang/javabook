package online.javabook.jcu.queue.blocking;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2018年7月19日
 *
 */
public class NotTreadSafeLinkedQueueMain {
	static Random random = new Random();

	public static void main(String[] args) {

		// 这个容器用来校验Queue中poll出的messageId是否重复
		ConcurrentHashMap<String, Thread> map = new ConcurrentHashMap<>();

		// message queue
		Queue<String> queue = new LinkedList<>();

		// 生产者向queue中创建messageId
		Thread producerThread = new Thread(() -> {
			while (true) {
				queue.offer(UUID.randomUUID().toString());
			}
		});

		// 消费者1消费queue中的messageId
		Thread consumerThread1 = new Thread(() -> {
			while (true) {
				//System.out.println("This queue size:" + queue.size());
				String messageId = queue.poll();

				if(messageId == null) {
					System.out.println("This messageId is NULL.");
				}else {
					Object value = map.putIfAbsent(messageId, Thread.currentThread());
					if(value!=null){
						System.out.println("This messageId [" + messageId + "] has been added by " + map.get(messageId) +
								", the current thread is " + Thread.currentThread());
					}
				}
			}
		});
		consumerThread1.setName("consumerThread1");

		// 消费者2消费queue中的messageId
		Thread consumerThread2 = new Thread(() -> {
			while (true) {
				//System.out.println("This queue size:" + queue.size());
				String messageId = queue.poll();

				if(messageId == null) {
					System.out.println("This messageId is NULL.");
				}else {
					Object value = map.putIfAbsent(messageId, Thread.currentThread());
					if(value!=null){
						System.out.println("This messageId [" + messageId + "] has been added by " + map.get(messageId) +
								", the current thread is " + Thread.currentThread());
					}
				}
			}
		});
		consumerThread2.setName("consumerThread2");

		producerThread.start();
		doSleep(10000);
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
