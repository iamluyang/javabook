package com.javabook.oom.germ;

import java.util.Random;


/**
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
			random.toString().intern();
		}
	}
}