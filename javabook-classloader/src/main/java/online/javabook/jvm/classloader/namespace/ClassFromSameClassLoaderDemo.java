package online.javabook.classloader.namespace;

import online.javabook.classloader.FileSysClassLoader;
import online.javabook.classloader.NetworkClassLoader;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class ClassFromSameClassLoaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			// --------------------------------------------------
			// File/URL			
			// --------------------------------------------------
			
			// URL
			String urls = "file:\\C:\\mybin";
			
			// File
			String file = "C:\\mybin\\";

			// --------------------------------------------------
			// FileSysClassLoader/NetworkClassLoader			
			// --------------------------------------------------
			
			// networkClassLoader
			NetworkClassLoader networkClassLoader = new NetworkClassLoader(urls);
			System.out.println("networkClassLoader.getParent() ->" + networkClassLoader.getParent());

			// fileSystemClassLoader
			FileSysClassLoader fileSysClassLoader = new FileSysClassLoader(file);
			System.out.println("fileSysClassLoader.getParent() ->" + fileSysClassLoader.getParent());

			// --------------------------------------------------
			// SimpleServiceLowerCaseImpl		
			// --------------------------------------------------
			
			// simpleServiceLowerCaseImpl
			String simpleServiceLowerCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceLowerCaseImpl";

			// simpleServiceLowerCaseImplClass1
			Class<?> simpleServiceLowerCaseImplClass1 = networkClassLoader.loadClass(simpleServiceLowerCaseImpl);

			// simpleServiceLowerCaseImplClass2
			Class<?> simpleServiceLowerCaseImplClass2 = networkClassLoader.loadClass(simpleServiceLowerCaseImpl);

			System.out.println("SimpleServiceLowerCaseImpl:");

			System.out.println(	simpleServiceLowerCaseImplClass1.getClassLoader() + " -> " + simpleServiceLowerCaseImplClass1.getName() );

			System.out.println(	simpleServiceLowerCaseImplClass2.getClassLoader() + " -> " + simpleServiceLowerCaseImplClass2.getName() );

			System.out.println( "simpleServiceLowerCaseImplClass1 == simpleServiceLowerCaseImplClass2 ? " + (simpleServiceLowerCaseImplClass1==simpleServiceLowerCaseImplClass2) );

			// --------------------------------------------------
			// SimpleServiceUpperCaseImpl
			// --------------------------------------------------

			// simpleServiceUpperCaseImpl
			String simpleServiceUpperCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceUpperCaseImpl";

			// simpleServiceUpperCaseImplClass1
			Class<?> simpleServiceUpperCaseImplClass1 = fileSysClassLoader.loadClass(simpleServiceUpperCaseImpl);

			// simpleServiceUpperCaseImplClass2
			Class<?> simpleServiceUpperCaseImplClass2 = fileSysClassLoader.loadClass(simpleServiceUpperCaseImpl);

			System.out.println("\nSimpleServiceUpperCaseImpl:");

			System.out.println(	simpleServiceUpperCaseImplClass1.getClassLoader() + " -> " + simpleServiceUpperCaseImplClass1.getName() );

			System.out.println(	simpleServiceUpperCaseImplClass2.getClassLoader() + " -> " + simpleServiceUpperCaseImplClass2.getName() );

			System.out.println( "simpleServiceUpperCaseImplClass1 == simpleServiceUpperCaseImplClass2 ? " + (simpleServiceUpperCaseImplClass1==simpleServiceUpperCaseImplClass2) );

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
