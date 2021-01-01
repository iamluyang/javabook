package online.javabook.exception.thread;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class ProducerThread extends Thread {

	/**
	 * queue
	 */
	private MyQueue queue;
	
	/**
	 * @param queue
	 */
	public ProducerThread(MyQueue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true){
			queue.offer(new Object());
		}
	}
}
