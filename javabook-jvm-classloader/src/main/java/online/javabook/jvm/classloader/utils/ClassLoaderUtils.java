package online.javabook.jvm.classloader.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class ClassLoaderUtils {

	/**
	 * @return
	 */
	public static ClassLoader getBootstrapLoader() {
		return getExtClassLoader().getParent();
	}
	
	/**
	 * @return
	 */
	public static ClassLoader getExtClassLoader() {
		return getAppClassLoader().getParent();
	}
	
	/**
	 * @return
	 */
	public static ClassLoader getAppClassLoader() {
		return ClassLoader.getSystemClassLoader();
	}
	
	/**
	 * @return
	 */
	public static ClassLoader getThreadClassLoader() {
		
		ClassLoader classLoader = null;
		try {
			classLoader = Thread.currentThread().getContextClassLoader();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classLoader;
	}

	/**
	 * @return
	 */
	public static ClassLoader getCurrentClassLoader() {
		return ClassLoaderUtils.class.getClassLoader();
	}

	/**
	 * @return
	 */
	public static ClassLoader[] getHierarchyClassLoadersDesc() {		
		List<ClassLoader> hierarchyClassLoaders = new ArrayList<ClassLoader>();
		getHierarchyClassLoaders(hierarchyClassLoaders, getCurrentClassLoader());
		Collections.reverse(hierarchyClassLoaders);
		return hierarchyClassLoaders.toArray(new ClassLoader[hierarchyClassLoaders.size()]);
	}

	/**
	 * @param classLoaders
	 * @param currentClassLoader
	 * @return
	 */
	private static void getHierarchyClassLoaders(Collection<ClassLoader> classLoaders, ClassLoader currentClassLoader) {
		classLoaders.add(currentClassLoader);
		if(currentClassLoader!=null) {
			ClassLoader parentClassLoader = currentClassLoader.getParent();
			getHierarchyClassLoaders(classLoaders, parentClassLoader);
		}
	}

	/**
	 *
	 */
	public static void printHierarchyClassLoadersDesc() {
		ClassLoader[] classLoaders = getHierarchyClassLoadersDesc();

		StringBuffer classLoaderTree = new StringBuffer();
		for (int i = 0; i < classLoaders.length; i++) {
			ClassLoader classLoader = classLoaders[i];

			for (int j = 0; j < i+1; j++) {
				classLoaderTree.append("-");
			}

			if(classLoader==null)
				classLoaderTree.append("null").append("\n");
			else
				classLoaderTree.append(classLoader.toString()).append("\n");
		}

		System.out.println(classLoaderTree);
	}
}
