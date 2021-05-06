package online.javabook.pattern.thread.future;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class FutureResult extends ResultWithListener {
	
	/**
	 * realResult
	 */
	private RealResult realResult = null;
	
	/**
	 * ready
	 */
	private boolean ready = false;

	/**
	 * @param realResult
	 */
	public synchronized void setRealResult(RealResult realResult) {
		
		if (ready) {
			return;
		}
		this.realResult = realResult;
		this.ready      = true;
		notifyAll();
	}

	public synchronized String getContent() {
		
		while (!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		return realResult.getContent();
	}
}
