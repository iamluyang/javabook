package online.javabook.jvm.thread.lock.readwritelock.jcu;

/**
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class ReaderThread extends Thread {

	/**
	 * resource
	 */
	private final Resource resource;

	/**
	 *
	 * @param resource
	 */
	public ReaderThread(Resource resource) {
		this.resource = resource;
	}

	public void run() {
		try {
			while (true) {
				char[] context = resource.read();
				System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(context));
			}
		} catch (InterruptedException e) {

		}

	}
}
