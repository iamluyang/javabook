package com.javabook.pattern.thread.twophasetermination1;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class WorkerThread extends Thread {

	/**
	 * counter
	 */
	private long counter = 30;

	// --------------------------------------------------------------------------------
	// shutdownRequested
	// --------------------------------------------------------------------------------
	
	/**
	 * shutdown request
	 */
	public void shutdown() {
		interrupt();
	}
	
	// --------------------------------------------------------------------------------
	// run
	// --------------------------------------------------------------------------------
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public final void run() {
		try {
			while (true) {
				doWork();
			}
		} catch (InterruptedException e) {
			
		}
	}

	/**
	 * @throws InterruptedException
	 */
	protected void doWork() throws InterruptedException {
		
		while(counter!=0){
			System.out.println("doWork: counter = " + counter);
			Thread.sleep(1000);
			counter--;
		}
		counter = 30;
	}
}
