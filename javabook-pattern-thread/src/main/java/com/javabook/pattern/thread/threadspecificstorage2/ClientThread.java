package com.javabook.pattern.thread.threadspecificstorage2;


/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015年7月19日
 *
 */
public class ClientThread extends Thread {
	
	/**
	 * @param name
	 */
	public ClientThread(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		System.out.println(getName() + " BEGIN");
		
		for (int index = 0; index < 10; index++) {
			Log.println("i = " + index);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		Log.close();
		
		System.out.println(getName() + " END");
	}
}
