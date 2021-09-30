package online.javabook.design.thread.workerthread;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Main {
	public static void main(String[] args) {
		
		Channel channel = new Channel(5);
		channel.startWorkers();
		
		new ClientThread("Alice", channel).start();
		new ClientThread("Bobby", channel).start();
		new ClientThread("Chris", channel).start();
	}
}
