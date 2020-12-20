package com.javabook.pattern.thread.future;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Main2 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("main BEGIN");
		
		Host host = new Host();
		Result data = host.requestAsync("ABC");

		System.out.println("main job1");

		data.addListener(new IListener() {
			@Override
			public void OnResult(String result) {
				System.out.println(result);
				// fill table
			}

			@Override
			public void OnException(Exception exception) {
				System.out.println(exception);
			}
		});

		// data.getContent();

		System.out.println("Draw Table");

		Thread.sleep(1000000);
	}
}
