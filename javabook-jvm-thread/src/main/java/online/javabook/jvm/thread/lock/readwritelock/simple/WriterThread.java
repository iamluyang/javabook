package online.javabook.jvm.thread.lock.readwritelock.simple;

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

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
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
