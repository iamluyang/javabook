package com.javabook.jvm.classinit;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ClassInitChild extends ClassInitParent {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3932266286266527472L;

	/**
	 * static field
	 */
	public static double staticfield_Compile_inChild = 1;
	
	/**
	 * static field - RunTime
	 */
	public static double staticfield_Runtime_inChild = Math.random();
	
	/**
	 * final static field - CompileTime
	 */
	public static final double finalstaticfield_Compile_inChild = 1;
	
	/**
	 * final static field - RunTime
	 */
	public static final double finalstaticfield_Runtime_inChild = Math.random();
	
	static{
		// 仅仅初始化执行一次
		System.out.println("I am static block of the ClassInitChild.");
	}

	public ClassInitChild() {
		System.out.println("I am constructor of the ClassInitChild.");
	}
}
