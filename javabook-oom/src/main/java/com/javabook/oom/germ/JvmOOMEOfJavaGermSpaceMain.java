package com.javabook.oom.germ;

import java.util.Random;
import java.util.UUID;


/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * -XX:PermSize=4M -XX:MaxPermSize=4M
 * 
 * java.lang.OutOfMemoryError: PermGen space
 * 
 * or
 * 
 * -XX:MaxMetaspaceSize=1M
 * 
 * Error occurred during initialization of VM
 * OutOfMemoryError: Metaspace
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class JvmOOMEOfJavaGermSpaceMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random random = new Random();
		for(;;){			
			UUID.randomUUID().toString().intern();
		}
	}
}