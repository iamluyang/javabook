package online.javabook.jvm.classloader.utils;

import sun.misc.Launcher;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class ClassLoaderUtilsMain {

	/**
	 * @param args
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		System.out.println("BootstrapLoader:"   + ClassLoaderUtils.getBootstrapLoader());
		System.out.println("ExtClassLoader:"    + ClassLoaderUtils.getExtClassLoader());
		System.out.println("AppClassLoader:"    + ClassLoaderUtils.getAppClassLoader());

		System.out.println("----------------------------------------------------------------");

		System.out.println("\nHierarchy-ClassLoadersDesc:");
		ClassLoaderUtils.printHierarchyClassLoadersDesc();

		System.out.println("----------------------------------------------------------------");

		System.out.println("java.lang.String.class.getClassLoader():" + String.class.getClassLoader());
		System.out.println("com.sun.java.accessibility.util.AWTEventMonitor.class.getClassLoader():" + com.sun.java.accessibility.util.AWTEventMonitor.class.getClassLoader());
		System.out.println("ClassLoaderUtilsMain.class.getClassLoader():" + ClassLoaderUtilsMain.class.getClassLoader());
		System.out.println("Thread.currentThread().getContextClassLoader():" + Thread.currentThread().getContextClassLoader());

		System.out.println("----------------------------------------------------------------");

		URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
		for (URL urL : urLs) {
			System.out.println(urL);
		}

		System.out.println("----------------------------------------------------------------");
		System.out.println(System.getProperty("java.ext.dirs"));

	}
}
