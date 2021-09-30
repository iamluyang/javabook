package online.javabook.jvm.gc.oom.thread.oome;


/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 *	at java.lang.Thread.start0(Native Method)
 *	at java.lang.Thread.start(Thread.java:717)
 *  at online.javabook.jvm.garbage.thread.thread.oome.JvmOutOfMemoryErrorOfThreadDemo.main(JvmOutOfMemoryErrorOfThreadDemo.java:39)
 * 
 * 原生线程会在堆以外的内存创建，因此受到本地物理内存的限制不能创建更多线程
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

		int count = 1;
		while(count>0){
			Thread thread = new Thread(count+""){
				public void run() {
					try {
						System.out.println(Thread.currentThread());
						Thread.sleep(1000*3600*24);
					} catch (Exception e) {
						e.printStackTrace();
					}
				};				
			};
			thread.start();
			count++;
		}
	}
}
