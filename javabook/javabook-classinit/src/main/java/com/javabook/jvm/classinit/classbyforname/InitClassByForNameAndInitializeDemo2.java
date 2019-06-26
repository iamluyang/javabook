package com.javabook.jvm.classinit.classbyforname;

/**
 * <ul>通过Class.forName加载指定类型
 * 	<li>观察类型的初始化顺序
 *  <li>观察类型的初始化次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByForNameAndInitializeDemo2 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("第1次加载ClassInit");
		Class.forName("com.javabook.jvm.classinit.ClassInitChild");
		
		System.out.println("第2次加载ClassInit");
		Class.forName("com.javabook.jvm.classinit.ClassInitChild");
	}
}