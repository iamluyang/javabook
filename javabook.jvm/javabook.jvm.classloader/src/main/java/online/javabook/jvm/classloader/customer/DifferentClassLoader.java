package online.javabook.jvm.classloader.customer;

import online.javabook.jvm.classloader.service.api.ISimpleService;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class DifferentClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			// simpleServiceLowerCaseImpl
			String simpleServiceLowerCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceLowerCaseImpl";

			// File
			String file = "C:\\mybin\\";

			// fileSystemClassLoader
			FileSysClassLoader fileSysClassLoader = new FileSysClassLoader(file);

			// ----------------------------------------------------------------------------------------------------
			// SimpleServiceLowerCaseImpl		
			// ----------------------------------------------------------------------------------------------------

			// simpleServiceLowerCaseImplClass2
			Class<?> simpleServiceLowerCaseImplClass1 = fileSysClassLoader.loadClass(simpleServiceLowerCaseImpl);
			System.out.println(	simpleServiceLowerCaseImplClass1.getClassLoader() + " -> " + simpleServiceLowerCaseImplClass1.getName());

			System.out.println("simpleServiceLowerCaseImplClass1.getClass().getClassLoader() -> " + simpleServiceLowerCaseImplClass1.getClass().getClassLoader());

			ISimpleService simpleServiceLowerCaseImpl1 = (ISimpleService) simpleServiceLowerCaseImplClass1.newInstance();
			System.out.println("simpleServiceLowerCaseImpl1.getClass().getClassLoader() -> " + simpleServiceLowerCaseImpl1.getClass().getClassLoader());

			// ----------------------------------------------------------------------------------------------------
			// SimpleServiceUpperCaseImpl		
			// ----------------------------------------------------------------------------------------------------
			System.out.println();

			// fileSystemClassLoader
			NetworkClassLoader networkClassLoader = new NetworkClassLoader("file:\\C:\\mybin");

			Class<?> simpleServiceLowerCaseImplClass2 = networkClassLoader.loadClass(simpleServiceLowerCaseImpl);
			System.out.println(	simpleServiceLowerCaseImplClass2.getClassLoader() + " -> " + simpleServiceLowerCaseImplClass2.getName());

			System.out.println("simpleServiceLowerCaseImplClass2.getClass().getClassLoader() -> " + simpleServiceLowerCaseImplClass2.getClass().getClassLoader());

			ISimpleService simpleServiceLowerCaseImpl2 = (ISimpleService) simpleServiceLowerCaseImplClass2.newInstance();
			System.out.println("simpleServiceLowerCaseImpl22.getClass().getClassLoader() -> " + simpleServiceLowerCaseImpl2.getClass().getClassLoader());

			System.out.println(simpleServiceLowerCaseImpl1.getClass().getName().equals(simpleServiceLowerCaseImpl2.getClass().getName()));
			System.out.println(simpleServiceLowerCaseImpl1.getClass() == simpleServiceLowerCaseImpl2.getClass());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
