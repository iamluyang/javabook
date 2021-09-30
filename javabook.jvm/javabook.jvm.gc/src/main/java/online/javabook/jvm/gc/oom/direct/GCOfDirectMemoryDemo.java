package online.javabook.jvm.gc.oom.direct;

import online.javabook.jvm.gc.MyUnsafe;

import java.nio.ByteBuffer;


/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * -XX:MaxDirectMemorySize=1024m -XX:+PrintGCDetails
 *
 * 直接内存触发GC
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class GCOfDirectMemoryDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Max Memory: "+ MyUnsafe.getMaxMemory());
		int _1MB = 1024 * 1024 * 100;

		while(true){
			ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1MB);
			Thread.sleep(50);
		}
	}
}