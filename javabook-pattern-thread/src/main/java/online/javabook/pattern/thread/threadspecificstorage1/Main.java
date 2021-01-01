package online.javabook.pattern.thread.threadspecificstorage1;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("BEGIN");
		
		for (int index = 0; index < 10; index++) {
			Log.println("main: i = " + index);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		Log.close();
		
		System.out.println("END");
	}
}
