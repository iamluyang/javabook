package com.javabook.pattern.thread.twophasetermination3;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("main: BEGIN");
		try {

			WorkerThread workerThread = new WorkerThread();
			workerThread.start();

			Thread.sleep(10000);

			System.out.println("main: shutdown");
			workerThread.shutdown();

			System.out.println("main: join");
			workerThread.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main: END");
	}
}
