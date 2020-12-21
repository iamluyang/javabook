package com.javabook.classloader.java.lang;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class VirusMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 和伪装的java.lang.Long不同，启动类加载器不能在JDK API中找到到Virus这个类
		// ClassLoader.preDefineClass方法通过判断包路径来决定是否加载或抛出安全异常
		// 当启动类加载器无法在java.*包路径中找以java作为包名的类则抛出安全异常
		Virus virus = new Virus();
		virus.whoAmI();
	}
}