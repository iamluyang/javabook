package com.javabook.security.packageaccess2;


/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-25
 *
 */
public class AccessTestClassInPackage2 {

    /**
     * @param args
     */
    public static void main(String[] args) { 
    	
    	// 不能访问另外一个包中的方法 
        //new ClassInPackage1().clazz.action();  
    }  
}
