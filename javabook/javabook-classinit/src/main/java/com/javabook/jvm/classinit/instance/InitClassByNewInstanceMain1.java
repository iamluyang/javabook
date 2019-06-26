package com.javabook.jvm.classinit.instance;

import com.javabook.jvm.classinit.ClassInitParent;

/**
 * <ul>newInstance的方式创建类型的对象
 * 	<li>观察类型的初始化顺序(当前类的静态块执行了，父类的静态块没有执行)
 *  <li>观察类型的初始化次数
 * 	<li>观察对象的初始化顺序(当前类构造函数执行了，父类构造函数没有执行)
 *  <li>观察对象的初始化次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByNewInstanceMain1 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		System.out.println("第1次以newInstance的方式创建类型的对象");
		ClassInitParent.class.newInstance();
		System.out.println("第2次以newInstance的方式创建类型的对象");
		ClassInitParent.class.newInstance();
	}
}