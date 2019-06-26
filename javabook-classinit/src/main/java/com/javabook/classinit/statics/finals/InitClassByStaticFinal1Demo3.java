package com.javabook.classinit.statics.finals;

import com.javabook.classinit.ClassInitChild;

/**
 * <ul>访问类型的final static编译期字段
 * 	<li>观察类型的初始化顺序
 *  <li>观察类型的初始化次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByStaticFinal1Demo3 {

	public static void main(String[] args) {
		
		System.out.println("第1次访问类型的final static字段(编译时)");
		System.out.println( ClassInitChild.finalstaticfield_Compile_inChild );
		
		System.out.println("第1次访问类型的final static字段(编译时)");
		System.out.println( ClassInitChild.finalstaticfield_Compile_inChild );
	}
}