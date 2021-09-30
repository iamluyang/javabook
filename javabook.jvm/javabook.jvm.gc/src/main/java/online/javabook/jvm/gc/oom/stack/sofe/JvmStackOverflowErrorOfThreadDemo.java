package online.javabook.jvm.gc.oom.stack.sofe;


/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * -Xms1024m -Xmx1024m -Xss108k -XX:+PrintGCDetails
 * 
 * Java线程栈溢出，线程栈在堆以外的内存创建，不会影响堆内存的变化
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class JvmStackOverflowErrorOfThreadDemo {

	/**
	 * count
	 */
	int count;
	
	/**
	 * recursion
	 * @throws InterruptedException 
	 */
	public void recursion() throws InterruptedException {
		System.out.println("Recursion level:"+count++);
		//Thread.sleep(100);
		recursion();		
	}
	
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(20000);
		JvmStackOverflowErrorOfThreadDemo sof = new JvmStackOverflowErrorOfThreadDemo();
		sof.recursion();
	}
}
