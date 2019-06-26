package com.book.mina.b;

import com.book.mina.c.ClassC;

public class ClassB {

	public void print() {
		System.out.println(this.getClass().getName());
		
		ClassC classC = new ClassC();
		classC.print();
	}
}
