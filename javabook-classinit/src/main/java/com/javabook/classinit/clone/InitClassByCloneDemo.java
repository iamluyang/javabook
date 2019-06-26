package com.javabook.classinit.clone;

import com.javabook.classinit.ClassInitParent;

public class InitClassByCloneDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("第1次创建ClassInitParent实例");
		ClassInitParent clazzInit1 = new ClassInitParent();
		
		System.out.println("第2次创建ClassInitChild实例");
		ClassInitParent clazzInit2 = new ClassInitParent();
	}
}