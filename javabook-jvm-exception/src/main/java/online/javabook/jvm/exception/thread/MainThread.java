package online.javabook.jvm.exception.thread;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class MainThread {

	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		
		Thread producerThread = new ProducerThread(queue);		
		Thread customerThread = new CustomerThread(queue);
		
		producerThread.start();
		customerThread.start();
		
		customerThread.interrupt();
	}
}
