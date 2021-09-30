package online.javabook.design.thread.workerthread;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Channel {
	
	/**
	 * MAX_REQUEST
	 */
	private static final int MAX_REQUEST = 100;
	
	/**
	 * requestQueue
	 */
	private final Request[] requestQueue;
	
	/**
	 * tail
	 */
	private int tail; 
	
	/**
	 * head
	 */
	private int head; 
	
	/**
	 * count
	 */
	private int count; 
	
	/**
	 * threadPool
	 */
	private final WorkerThread[] threadPool;

	/**
	 * @param threads
	 */
	public Channel(int threads) {
		
		// requestQueue
		this.requestQueue = new Request[MAX_REQUEST];
		this.head         = 0;
		this.tail         = 0;
		this.count        = 0;

		// threadPool
		threadPool = new WorkerThread[threads];
		for (int i = 0; i < threadPool.length; i++) {
			threadPool[i] = new WorkerThread("Worker-" + i, this);
		}
	}

	/**
	 * start Workers
	 */
	public void startWorkers() {
		for (int i = 0; i < threadPool.length; i++) {
			threadPool[i].start();
		}
	}

	/**
	 * @param request
	 */
	public synchronized void putRequest(Request request) {
		
		while (count >= requestQueue.length) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		requestQueue[tail] = request;
		tail = (tail + 1) % requestQueue.length;
		count++;
		notifyAll();
	}

	/**
	 * @return
	 */
	public synchronized Request takeRequest() {
		
		while (count <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		Request request = requestQueue[head];
		head = (head + 1) % requestQueue.length;
		count--;
		notifyAll();
		return request;
	}
}
