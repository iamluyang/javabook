package com.javabook.security.packageaccess2;


import com.javabook.security.packageaccess1.ClassInPackage1;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class AccessTestClassInPackage2 {

    /**
     * @param args
     */
    public static void main(String[] args) { 

        ClassInPackage1 clazz = new ClassInPackage1();
        // 不能访问另外一个包中的方法
        //clazz.action();
    }  
}
