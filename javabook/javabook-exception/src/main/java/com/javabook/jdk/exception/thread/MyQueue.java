package com.javabook.jdk.exception.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class MyQueue {

	/**
	 * 
	 */
	private List<Object> list = new ArrayList<Object>();

	/**
	 * @param object
	 */
	public synchronized void offer(Object object){			
		list.add(object);
		notifyAll();
	}

	/**
	 * @return 
	 * 
	 */
	public synchronized Object poll(){		
		while(list.isEmpty()) {
			try {
				wait();								
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		return list.get(0);
	}
}
