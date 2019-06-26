package com.javabook.classinit.classbyforname;

/**
 * <ul>通过Class.forName加载指定类型
 * 	<li>观察类型是否初始化
 *  <li>观察类型和的父类型是否初始化
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByForNameAndNotInitializeDemo2 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("第1次加载ClassInitChild");
		Class.forName("com.javabook.jvm.classinit.ClassInitChild",false, InitClassByForNameAndNotInitializeDemo2.class.getClassLoader());
		
		System.out.println("第2次加载ClassInitChild");
		Class.forName("com.javabook.jvm.classinit.ClassInitChild",false, InitClassByForNameAndNotInitializeDemo2.class.getClassLoader());
	}
}