package online.javabook.jvm.garbage.thread.thread.oome;


/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 *	at java.lang.Thread.start0(Native Method)
 *	at java.lang.Thread.start(Thread.java:691)
 * 
 * 线程在堆以外的内存创建，因此受到内存限制不能创建更多线程，不会影响堆内存的变化
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class JvmOutOfMemoryErrorOfThreadDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		//Thread.sleep(30000);
		for(;;){			
			Thread thread = new Thread(){
				public void run() {
					try {
						System.out.println(Thread.currentThread());
						Thread.sleep(1000*3600*24);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				};				
			};
			thread.start();
		}
	}
}
