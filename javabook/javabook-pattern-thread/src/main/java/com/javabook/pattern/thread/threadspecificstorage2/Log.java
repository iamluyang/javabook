package com.javabook.pattern.thread.threadspecificstorage2;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Log {
	
	/**
	 * tsLogCollection
	 */
	private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

	/**
	 * @param s
	 */
	public static void println(String s) {
		getTSLog().println(s);
	}

	/**
	 * 
	 */
	public static void close() {
		getTSLog().close();
	}

	/**
	 * @return
	 */
	private static TSLog getTSLog() {
		
		TSLog tsLog = (TSLog) tsLogCollection.get();

		if (tsLog == null) {
			tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
			tsLogCollection.set(tsLog);
		}

		return tsLog;
	}
}
