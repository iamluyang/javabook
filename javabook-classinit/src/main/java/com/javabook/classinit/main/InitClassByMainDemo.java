package com.javabook.classinit.main;

/**
 * <ul>通过执行main方法初始化当前类型
 * 	<li>观察当前类型是否被初始化
 *  <li>观察当前类型的构造函数是否执行
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByMainDemo {
	
	static{
		System.out.println("I am static block of the InitClassByMainDemo");
	}
	
	public InitClassByMainDemo() {
		System.out.println("I am constructor of the InitClassByMainDemo.");
	}
	
	public static void main(String[] args) throws ClassNotFoundException {

	}
}