package online.javabook.a;

import online.javabook.b.ClassB;

public class ClassA {

	public void print() {
		//char a = "\u000a; 
		System.out.println(\u000a);
		System.out.println(this.getClass().getName());
		ClassB classB = new ClassB();
		classB.print();
	}

	public static void main(String[] args) {
		ClassA classA = new ClassA();
		classA.print();
	}
}
