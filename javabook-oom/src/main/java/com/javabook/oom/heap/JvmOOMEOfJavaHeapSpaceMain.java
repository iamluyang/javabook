package com.javabook.oom.heap;

import java.util.LinkedList;
import java.util.List;

/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * -Xms1024m -Xmx1024m -XX:+PrintGCDetails
 * 
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at com.javabook.jvm.oom.heap.JvmOOMEOfJavaHeapSpaceMain.main(JvmOOMEOfJavaHeapSpaceMain.java:26)
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class JvmOOMEOfJavaHeapSpaceMain {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		List<byte[]> data = new LinkedList<byte[]>();
		for(;;){			
			byte[] _1MB = new byte[1024*1024*1];
			data.add(_1MB);
			Thread.sleep(100);
		}
	}
}
