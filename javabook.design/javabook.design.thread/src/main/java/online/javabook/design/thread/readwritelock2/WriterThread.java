package online.javabook.design.thread.readwritelock2;

import java.util.Random;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class WriterThread extends Thread {

	/**
	 * random
	 */
	private static final Random random = new Random();

	/**
	 * resource
	 */
	private final Resource resource;

	/**
	 * context
	 */
	private final char context;

	/**
	 *
	 * @param resource
	 * @param context
	 */
	public WriterThread(Resource resource, char context) {
		this.resource = resource;
		this.context   = context;
	}

	public void run() {
		try {
			while (true) {
				resource.write(context);
				Thread.sleep(random.nextInt(3000));
			}
		} catch (InterruptedException e) {
		}
	}
}
