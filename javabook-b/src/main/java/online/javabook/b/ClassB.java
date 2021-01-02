package online.javabook.b;

import online.javabook.c.ClassC;

public class ClassB {

	public void print() {
		System.out.println(this.getClass().getName());
		
		ClassC classC = new ClassC();
		classC.print();
	}
}
