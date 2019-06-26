package com.javabook.thread.type.daemon;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-22
 *
 */
public class DaemonThread extends Thread {

	public DaemonThread() {
		this.setDaemon(true);
	}

	@Override
	public void run() {
		while (true)
			Math.pow(Math.PI, 2);
	}

}
