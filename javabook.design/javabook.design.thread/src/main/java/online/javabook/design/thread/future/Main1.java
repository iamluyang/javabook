package online.javabook.design.thread.future;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Main1 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("main BEGIN");
		
		Host host = new Host();
		Result data1 = host.requestAsync("ABC");
		Result data2 = host.requestAsync("DEF");
		Result data3 = host.requestAsync("GHI");

		System.out.println("main otherJob BEGIN");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		System.out.println("main otherJob END");

		System.out.println("data1 = " + data1.getContent());
		System.out.println("data2 = " + data2.getContent());
		System.out.println("data3 = " + data3.getContent());

		System.out.println("main END");
	}
}
