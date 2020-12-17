package com.javabook.pattern.thread.guardedsuspension;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		// myaddress
		RequestQueue requestQueue = new RequestQueue();
		
		new ClientThread(requestQueue, "Alice", 3141592L).start();
		new ServerThread(requestQueue, "Bobby", 6535897L).start();
	}
}
