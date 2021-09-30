package online.javabook.jvm.thread.lock.readwritelock.unsafe;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		Resource resource = new Resource();

		// ReaderThread
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();

		// WriterThread
		new WriterThread(resource, 'A').start();
		new WriterThread(resource, 'B').start();
		new WriterThread(resource, 'C').start();
	}
}
