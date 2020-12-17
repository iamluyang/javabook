package com.javabook.pattern.thread.guardedsuspension;

import org.omg.CORBA.UShortSeqHelper;

import java.util.LinkedList;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class RequestQueue {
	
	/**
	 * queue
	 */
	private final LinkedList<Request> queue = new LinkedList<Request>();

	/**
	 * @return
	 */
	public synchronized Request getRequest() {
		
		// guarded
		while (queue.size() <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		return (Request) queue.removeFirst();
	}

	/**
	 * @param request
	 */
	public synchronized void putRequest(Request request) {
		queue.addLast(request);
		notifyAll();
	}
}
