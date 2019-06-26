package com.javabook.pattern.thread.singlethreadedexecution2;


/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015年7月19日
 *
 */
public class UserThread extends Thread {
	
	/**
	 * gate
	 */
	private final Gate gate;
	
	/**
	 * myname
	 */
	private final String myname;
	
	/**
	 * myaddress
	 */
	private final String myaddress;

	/**
	 * @param gate
	 * @param myname
	 * @param myaddress
	 */
	public UserThread(Gate gate, String myname, String myaddress) {
		this.gate      = gate;
		this.myname    = myname;
		this.myaddress = myaddress;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		System.out.println(myname + " BEGIN");
		while (true) {
			gate.pass(myname, myaddress);
		}
	}
}
