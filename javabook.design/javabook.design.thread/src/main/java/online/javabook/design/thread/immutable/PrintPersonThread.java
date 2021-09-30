package online.javabook.design.thread.immutable;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class PrintPersonThread extends Thread {
	
	/**
	 * person
	 */
	private Person person;

	/**
	 * @param person
	 */
	public PrintPersonThread(Person person) {
		this.person = person;
	}

	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " prints " + person);
		}
	}
}
