package com.javabook.jvm.classinit.classbyforname;

/**
 * <ul>通过Class.forName加载指定类型
 * 	<li>观察类型是否初始化
 *  <li>观察类型和的父类型是否初始化
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByForNameAndNotInitializeDemo1 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("第1次加载ClassInitParent");
		Class.forName("com.javabook.jvm.classinit.ClassInitParent",false, InitClassByForNameAndNotInitializeDemo1.class.getClassLoader());
		
		System.out.println("第2次加载ClassInitParent");
		Class.forName("com.javabook.jvm.classinit.ClassInitParent",false, InitClassByForNameAndNotInitializeDemo1.class.getClassLoader());
	}
}