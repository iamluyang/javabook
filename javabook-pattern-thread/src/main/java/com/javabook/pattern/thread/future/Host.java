package com.javabook.pattern.thread.future;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Host {
	
	/**
	 * @param count
	 * @param c
	 * @return
	 */
	public Result request(final int count, final char c) {
		
		System.out.println("    request(" + count + ", " + c + ") BEGIN");

		final FutureResult future = new FutureResult();

		new Thread() {
			public void run() {
				RealResult realdata = new RealResult(count, c);
				future.setRealResult(realdata);
			}
		}.start();

		System.out.println("    request(" + count + ", " + c + ") END");

		return future;
	}
}
