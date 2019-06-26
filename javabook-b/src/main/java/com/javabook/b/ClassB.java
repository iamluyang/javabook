package com.javabook.b;

import com.javabook.c.ClassC;

public class ClassB {

	public void print() {
		System.out.println(this.getClass().getName());
		
		ClassC classC = new ClassC();
		classC.print();
	}
}
