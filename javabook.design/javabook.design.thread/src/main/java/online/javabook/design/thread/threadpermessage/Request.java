package online.javabook.design.thread.threadpermessage;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Request {
	
	/**
	 * @param count
	 * @param c
	 */
	public void handle(int count, char c) {
		
		System.out.println("	handle(" + count + ", " + c + ") BEGIN");
		for (int index = 0; index < count; index++) {
			slowly();
			System.out.print(c);
		}
		System.out.println("");
		System.out.println("	handle(" + count + ", " + c + ") END");
	}

	/**
	 * 
	 */
	private void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
}
