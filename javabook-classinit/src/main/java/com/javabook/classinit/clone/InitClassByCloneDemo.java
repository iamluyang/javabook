package com.javabook.classinit.clone;

import com.javabook.classinit.ParentClass;

public class InitClassByCloneDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("第1次创建ClassInitParent实例");
		ParentClass clazzInit1 = new ParentClass();
		
		System.out.println("第2次创建ClassInitChild实例");
		ParentClass clazzInit2 = new ParentClass();
	}
}