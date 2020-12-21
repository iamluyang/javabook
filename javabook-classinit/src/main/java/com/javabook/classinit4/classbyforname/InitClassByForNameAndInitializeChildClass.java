package com.javabook.classinit4.classbyforname;

/**
 * <ul>通过Class.forName加载指定类型
 * 	<li>观察类型的静态块的初始化顺序
 *  <li>观察类型的静态块的初始化次数
 *  <li>观察类型的构造函数是否被调用
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByForNameAndInitializeChildClass {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("第1次加载ChildClass");
		Class class1 = Class.forName("com.javabook.classinit.ChildClass");
		
		System.out.println("第2次加载ChildClass");
		Class class2 = Class.forName("com.javabook.classinit.ChildClass");

		System.out.println("class1 == class2 -> " + (class1 == class2));
	}
}