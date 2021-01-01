package online.javabook.pattern.thread.balking;

import java.io.IOException;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class SaverThread extends Thread {
	
	/**
	 * resource
	 */
	private Resource resource;

	/**
	 * @param name
	 * @param resource
	 */
	public SaverThread(String name, Resource resource) {
		super(name);
		this.resource = resource;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		try {
			while (true) {
				resource.save();
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}
}