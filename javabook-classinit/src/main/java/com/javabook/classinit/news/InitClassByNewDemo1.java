package com.javabook.classinit.news;

import com.javabook.classinit.ClassInitParent;

/**
 * <ul>通过new一个类型的对象初始化当前类，并初始化新创建的对象
 * 	<li>观察类型的初始化顺序
 *  <li>观察类型的初始化次数
 *  <li>观察对象的初始化顺序
 *  <li>观察对象的初始化次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByNewDemo1 {

	public static void main(String[] args) {
		
		System.out.println("第1次新建ClassInitParent类型的对象");
		ClassInitParent clazzInit1 = new ClassInitParent();
		
		System.out.println("第2次新建ClassInitParent类型的对象");
		ClassInitParent clazzInit2 = new ClassInitParent();
	}
}
