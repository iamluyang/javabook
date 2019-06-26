package com.javabook.pattern.thread.future;


/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015年7月19日
 *
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("main BEGIN");
		
		Host host = new Host();
		Result data1 = host.request(10, 'A');
		Result data2 = host.request(20, 'B');
		Result data3 = host.request(30, 'C');

		/*System.out.println("main otherJob BEGIN");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		System.out.println("main otherJob END");*/

		System.out.println("data1 = " + data1.getContent());
		System.out.println("data2 = " + data2.getContent());
		System.out.println("data3 = " + data3.getContent());
		
		System.out.println("main END");
	}
}
