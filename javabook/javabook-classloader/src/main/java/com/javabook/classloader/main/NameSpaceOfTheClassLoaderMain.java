package com.javabook.classloader.main;

import com.javabook.classloader.FileSysClassLoader;
import com.javabook.classloader.NetworkClassLoader;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-25
 *
 */
public class NameSpaceOfTheClassLoaderMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			// --------------------------------------------------
			// File/URL			
			// --------------------------------------------------
			
			// URL
			String urls = "file:\\E:\\workshop\\J2EE\\workshop_book\\book_classloader\\mybin";
			
			// File
			String file = "E:\\workshop\\J2EE\\workshop_book\\book_classloader\\mybin";

			// --------------------------------------------------
			// FileSysClassLoader/NetworkClassLoader			
			// --------------------------------------------------
			
			// networkClassLoader
			NetworkClassLoader networkClassLoader = new NetworkClassLoader(urls);
			
			// fileSystemClassLoader
			FileSysClassLoader fileSysClassLoader = new FileSysClassLoader(file);

			// --------------------------------------------------
			// SimpleServiceLowerCaseImpl		
			// --------------------------------------------------
			
			// simpleServiceLowerCaseImpl
			String simpleServiceLowerCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceLowerCaseImpl";

			// simpleServiceLowerCaseImplClass1
			Class<?> simpleServiceLowerCaseImplClass1 = networkClassLoader.loadClass(simpleServiceLowerCaseImpl);

			// simpleServiceLowerCaseImplClass2
			Class<?> simpleServiceLowerCaseImplClass2 = fileSysClassLoader.loadClass(simpleServiceLowerCaseImpl);

			System.out.println("SimpleServiceLowerCaseImpl:");
			
			System.out.println(	simpleServiceLowerCaseImplClass1.getName()+":"+simpleServiceLowerCaseImplClass1.getClassLoader() );
	
			System.out.println(	simpleServiceLowerCaseImplClass2.getName()+":"+simpleServiceLowerCaseImplClass2.getClassLoader() );
			
			System.out.println( "ClassLoader of the SimpleServiceLowerCaseImpl:" + (simpleServiceLowerCaseImplClass1==simpleServiceLowerCaseImplClass2) );

			// --------------------------------------------------
			// SimpleServiceUpperCaseImpl		
			// --------------------------------------------------

			// simpleServiceUpperCaseImpl
			String simpleServiceUpperCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceUpperCaseImpl";		
			
			// simpleServiceUpperCaseImplClass1
			Class<?> simpleServiceUpperCaseImplClass1 = networkClassLoader.loadClass(simpleServiceUpperCaseImpl);

			// simpleServiceUpperCaseImplClass2
			Class<?> simpleServiceUpperCaseImplClass2 = fileSysClassLoader.loadClass(simpleServiceUpperCaseImpl);

			System.out.println("\nSimpleServiceUpperCaseImpl:");
			
			System.out.println(	simpleServiceUpperCaseImplClass1.getName()+":"+simpleServiceUpperCaseImplClass1.getClassLoader() );
			
			System.out.println(	simpleServiceUpperCaseImplClass2.getName()+":"+simpleServiceUpperCaseImplClass2.getClassLoader() );
			
			System.out.println( "ClassLoader of the SimpleServiceUpperCaseImpl:" + (simpleServiceUpperCaseImplClass1==simpleServiceUpperCaseImplClass2) );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
