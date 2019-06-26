package com.javabook.jdk.exception.thread;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class CustomerThread extends Thread{

	/**
	 * queue
	 */
	private MyQueue queue;
	
	/**
	 * @param queue
	 */
	public CustomerThread(MyQueue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {		
		while(true){
			queue.poll();
		}
	}
}
