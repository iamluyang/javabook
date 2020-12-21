package com.javabook.oom.thread.sofe;


/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * -Xms1024m -Xmx1024m -Xss108k
 * 
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at sun.nio.cs.UTF_8.updatePositions(UTF_8.java:77)
 * 	at sun.nio.cs.UTF_8.access$200(UTF_8.java:57)
 * 	at sun.nio.cs.UTF_8$Encoder.encodeArrayLoop(UTF_8.java:636)
 * 	at sun.nio.cs.UTF_8$Encoder.encodeLoop(UTF_8.java:691)
 * 	at java.nio.charset.CharsetEncoder.encode(CharsetEncoder.java:579)
 * 	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:271)
 * 	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
 * 	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
 * 	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
 * 	at java.io.PrintStream.write(PrintStream.java:526)
 * 	at java.io.PrintStream.print(PrintStream.java:597)
 * 	at java.io.PrintStream.println(PrintStream.java:736)
 * 	at com.javabook.jvm.oom.thread.sofe.JvmSOFEOfThreadMain.recursion(JvmSOFEOfThreadMain.java:28)
 * 	at com.javabook.jvm.oom.thread.sofe.JvmSOFEOfThreadMain.recursion(JvmSOFEOfThreadMain.java:30)
 * 	at com.javabook.jvm.oom.thread.sofe.JvmSOFEOfThreadMain.recursion(JvmSOFEOfThreadMain.java:30)
 * 	at com.javabook.jvm.oom.thread.sofe.JvmSOFEOfThreadMain.recursion(JvmSOFEOfThreadMain.java:30)
 * 	at com.javabook.jvm.oom.thread.sofe.JvmSOFEOfThreadMain.recursion(JvmSOFEOfThreadMain.java:30)
 * 
 * Java线程栈溢出，线程栈在堆以外的内存创建，不会影响堆内存的变化
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class JvmSOFEOfThreadMain {

	/**
	 * count
	 */
	int count;
	
	/**
	 * recursion
	 * @throws InterruptedException 
	 */
	public void recursion() throws InterruptedException {
		System.out.println(count++);
		Thread.sleep(10);
		recursion();		
	}
	
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		JvmSOFEOfThreadMain sof = new JvmSOFEOfThreadMain();
		sof.recursion();
	}
}
