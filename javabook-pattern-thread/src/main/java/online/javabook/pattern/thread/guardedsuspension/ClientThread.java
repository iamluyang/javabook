package online.javabook.pattern.thread.guardedsuspension;

import java.util.Random;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class ClientThread extends Thread {
	
	/**
	 * random
	 */
	private Random random;
	
	/**
	 * requestQueue
	 */
	private RequestQueue requestQueue;

	/**
	 * @param requestQueue
	 * @param name
	 * @param seed
	 */
	public ClientThread(RequestQueue requestQueue, String name, long seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random       = new Random(seed);
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		for (int i = 0; i < 10000; i++) {
			
			Request request = new Request("No." + i);
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			requestQueue.putRequest(request);
			
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
			}
		}
	}
}
