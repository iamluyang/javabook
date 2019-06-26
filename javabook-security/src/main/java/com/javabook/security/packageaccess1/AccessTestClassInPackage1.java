package com.javabook.security.packageaccess1;


/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-25
 *
 */
public class AccessTestClassInPackage1 {
	
	/** 
     * @param args 
     */  
    public static void main(String[] args) {  
    	
        ClassInPackage1 clazz = new ClassInPackage1();  
        // 可以访问当前包中方法
        clazz.action();  
    }  
}
