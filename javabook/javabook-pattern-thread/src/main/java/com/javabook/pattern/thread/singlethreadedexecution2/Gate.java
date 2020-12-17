package com.javabook.pattern.thread.singlethreadedexecution2;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Gate {
	
	/**
	 * counter
	 */
	private int counter = 0;
	
	/**
	 * name
	 */
	private String name = "Nobody";
	
	/**
	 * address
	 */
	private String address = "Nowhere";

	/**
	 * @param name
	 * @param address
	 */
	public synchronized void pass(String name, String address) {
		this.counter++;
		this.name    = name;
		this.address = address;
		check();
	}

	/**
	 * 
	 */
	private void check() {
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("***** BROKEN ***** " + toString());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public synchronized String toString() {
		return "No." + counter + ": " + name + ", " + address;
	}

}
