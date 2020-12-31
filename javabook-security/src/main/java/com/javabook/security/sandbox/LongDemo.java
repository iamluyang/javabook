package com.javabook.security.sandbox;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class LongDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 实际上代码无法加载这个伪装的Long，最终得到的还是JDK API中提供的Long
		// 类加载器通过双亲委托模式，最终使用启动类加载器得到JDK API中提供的Long
		Long badLong = new Long(1);
		System.out.println("ClassLoader:" + badLong.getClass().getClassLoader());
	}
}
