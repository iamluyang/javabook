package com.javabook.thread.type.running;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class RunningThread extends Thread {

	@Override
	public void run() {
		while (true)
			Math.pow(Math.PI, 2);
	}
}
