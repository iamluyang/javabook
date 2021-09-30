package online.javabook.design.thread.workerthread;

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
	 * channel
	 */
	private final Channel channel;
	
	/**
	 * random
	 */
	private static final Random random = new Random();

	/**
	 * @param name
	 * @param channel
	 */
	public ClientThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}

	public void run() {
		try {
			for (int i = 0; true; i++) {
				Request request = new Request(getName(), i);
				channel.putRequest(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {
			
		}
	}
}
