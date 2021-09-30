package online.javabook.design.thread.twophasetermination2;


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

	/**
	 * shutdownRequested
	 */
	private volatile boolean shutdown = false;

	// --------------------------------------------------------------------------------
	// shutdownRequested
	// --------------------------------------------------------------------------------
	
	/**
	 * shutdown request
	 */
	public void shutdown() {
		
		// shutdown
		shutdown = true;
	}

	/**
	 * @return
	 */
	public boolean isShutdown() {
		return shutdown;
	}

	// --------------------------------------------------------------------------------
	// run
	// --------------------------------------------------------------------------------
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public final void run() {
		try {
			while (!shutdown) {
				doWork();
			}
		} catch (InterruptedException e) {
			
		} finally {
			doShutdown();
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

	/**
	 * do shutdown
	 */
	protected void doShutdown() {
		System.out.println("doShutdown: counter = " + counter);
	}

}
