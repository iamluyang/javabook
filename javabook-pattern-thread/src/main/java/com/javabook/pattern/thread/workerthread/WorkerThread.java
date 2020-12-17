package com.javabook.pattern.thread.workerthread;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class WorkerThread extends Thread {
	
	/**
	 * channel
	 */
	private final Channel channel;

	/**
	 * @param name
	 * @param channel
	 */
	public WorkerThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		while (true) {
			Request request = channel.takeRequest();
			request.execute();
		}
	}
}
