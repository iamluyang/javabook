package com.javabook.thread.sync;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015-1-27
 *
 */
public interface ICounter {

	/**
	 * 返回当前值
	 * 
	 * @return
	 */
	public long get();

	/**
	 * 递增当前值
	 * 
	 * @return
	 */
	public long increment();

	/**
	 * 递减当前值
	 * 
	 * @return
	 */
	public long decrement();
}