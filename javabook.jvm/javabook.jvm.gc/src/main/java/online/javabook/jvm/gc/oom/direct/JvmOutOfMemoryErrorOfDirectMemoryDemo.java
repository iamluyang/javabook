package online.javabook.jvm.gc.oom.direct;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import online.javabook.jvm.gc.MyUnsafe;


/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * -XX:MaxDirectMemorySize=1024m
 * 
 *Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 *	at java.nio.Bits.reserveMemory(Bits.java:658)
 *	at java.nio.DirectByteBuffer.<init>(DirectByteBuffer.java:123)
 *	at java.nio.ByteBuffer.allocateDirect(ByteBuffer.java:311)
 *	at com.javabook.jvm.oom.thread.direct.JvmOOMEOfDirectMemoryMain.main(JvmOOMEOfDirectMemoryMain.java:33)
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class JvmOutOfMemoryErrorOfDirectMemoryDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Max Memory: "+ MyUnsafe.getMaxMemory());

		int _1MB = 1024 * 1024;
		List<ByteBuffer> byteBuffers = new ArrayList<ByteBuffer>();
		while(true){
			ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1MB);
			byteBuffers.add(byteBuffer);
			System.out.println("Reserved Memory: "+MyUnsafe.getReservedMemory());
			Thread.sleep(50);
		}		
	}
}