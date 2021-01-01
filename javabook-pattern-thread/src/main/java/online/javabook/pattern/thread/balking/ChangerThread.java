package online.javabook.pattern.thread.balking;

import java.io.IOException;
import java.util.Random;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class ChangerThread extends Thread {
	
	/**
	 * resource
	 */
	private Resource resource;
	
	/**
	 * random
	 */
	private Random random = new Random();

	/**
	 * @param name
	 * @param resource
	 */
	public ChangerThread(String name, Resource resource) {
		super(name);
		this.resource = resource;
	}

	public void run() {
		try {
			for (int index = 0; true; index++) {
				resource.change("No." + index);
				Thread.sleep(random.nextInt(1000));
				resource.save();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}
}
