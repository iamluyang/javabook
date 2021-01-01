package online.javabook.pattern.thread.readwritelock1;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		Resource resource = new Resource(10);
		
		// ReaderThread
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		new ReaderThread(resource).start();
		
		// WriterThread
		new WriterThread(resource, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
		new WriterThread(resource, "abcdefghijklmnopqrstuvwxyz").start();
	}
}
