package com.javabook.jdk.exception.thread;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class MainThread {

	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		
		Thread producerThread = new ProducerThread(queue);		
		Thread customerThread = new CustomerThread(queue);
		
		producerThread.start();
		customerThread.start();
		
		customerThread.interrupt();
	}
}
