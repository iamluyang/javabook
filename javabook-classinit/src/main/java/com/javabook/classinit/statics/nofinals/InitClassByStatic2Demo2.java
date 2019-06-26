package com.javabook.classinit.statics.nofinals;

import com.javabook.classinit.ClassInitChild;

/**
 * <ul>访问类型的final static运行期字段
 * 	<li>观察类型的初始化顺序
 *  <li>观察类型的初始化次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByStatic2Demo2 {

	public static void main(String[] args) {	
		
		System.out.println("第1次访问类型的static字段(运行时)");
		System.out.println( ClassInitChild.staticfield_Runtime_inChild);
		
		System.out.println("第2次访问类型的static字段(运行时)");
		System.out.println( ClassInitChild.staticfield_Runtime_inChild );
	}
}