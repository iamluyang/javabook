package com.javabook.classloader.main;

import com.javabook.classloader.FileSysClassLoader;
import com.javabook.classloader.NetworkClassLoader;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class NameSpaceOfTheClassLoaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			// --------------------------------------------------
			// File/URL			
			// --------------------------------------------------
			
			// URL
			String urls = "file:\\C:\\Github\\study\\javabook\\javabook-classloader\\mybin\\";
			
			// File
			String file = "C:\\Github\\study\\javabook\\javabook-classloader\\mybin\\";

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

			// simpleServiceLowerCaseImplClass3
			Class<?> simpleServiceLowerCaseImplClass3 = Class.forName(simpleServiceLowerCaseImpl);

			System.out.println("SimpleServiceLowerCaseImpl:");
			
			System.out.println(	simpleServiceLowerCaseImplClass1.getName()+":"+simpleServiceLowerCaseImplClass1.getClassLoader() );
	
			System.out.println(	simpleServiceLowerCaseImplClass2.getName()+":"+simpleServiceLowerCaseImplClass2.getClassLoader() );

			System.out.println(	simpleServiceLowerCaseImplClass3.getName()+":"+simpleServiceLowerCaseImplClass3.getClassLoader() );

			System.out.println( "simpleServiceLowerCaseImplClass1 == simpleServiceLowerCaseImplClass2" + (simpleServiceLowerCaseImplClass1==simpleServiceLowerCaseImplClass2) );

			// --------------------------------------------------
			// SimpleServiceUpperCaseImpl		
			// --------------------------------------------------

			// simpleServiceUpperCaseImpl
			String simpleServiceUpperCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceUpperCaseImpl";		
			
			// simpleServiceUpperCaseImplClass1
			Class<?> simpleServiceUpperCaseImplClass1 = networkClassLoader.loadClass(simpleServiceUpperCaseImpl);

			// simpleServiceUpperCaseImplClass2
			Class<?> simpleServiceUpperCaseImplClass2 = fileSysClassLoader.loadClass(simpleServiceUpperCaseImpl);

			// simpleServiceLowerCaseImplClass3
			Class<?> simpleServiceUpperCaseImplClass3 = Class.forName(simpleServiceUpperCaseImpl);

			System.out.println("\nSimpleServiceUpperCaseImpl:");
			
			System.out.println(	simpleServiceUpperCaseImplClass1.getName()+":"+simpleServiceUpperCaseImplClass1.getClassLoader() );
			
			System.out.println(	simpleServiceUpperCaseImplClass2.getName()+":"+simpleServiceUpperCaseImplClass2.getClassLoader() );

			System.out.println(	simpleServiceUpperCaseImplClass3.getName()+":"+simpleServiceUpperCaseImplClass3.getClassLoader() );

			System.out.println( "simpleServiceUpperCaseImplClass1 == simpleServiceUpperCaseImplClass2" + (simpleServiceUpperCaseImplClass1==simpleServiceUpperCaseImplClass2) );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
