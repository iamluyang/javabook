package com.javabook.classloader.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
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
	 * @return
	 */
	public static ClassLoader[] getHierarchyClassLoadersAsce() {		
		List<ClassLoader> hierarchyClassLoaders = new Stack<ClassLoader>();
		getHierarchyClassLoaders(hierarchyClassLoaders, getCurrentClassLoader());
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
		printHierarchyClassLoaders(getHierarchyClassLoadersDesc());
	}

	/**
	 * 
	 */
	public static void printHierarchyClassLoadersAsce() {		
		printHierarchyClassLoaders(getHierarchyClassLoadersAsce());
	}

	/**
	 * @param classLoaders
	 */
	private static void printHierarchyClassLoaders(ClassLoader[] classLoaders) {
		
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
		
		System.out.print(classLoaderTree);
	}
	
    // ----------------------------------------------------------------------
    // Class
    // ----------------------------------------------------------------------

	/**
	 * @param className
	 * @param classLoader
	 * @return
	 * @throws ClassNotFoundException 
	 */
	public static Class<?> getClass(String className, ClassLoader classLoader) throws ClassNotFoundException {

		Class<?> clazz = null;
		try {
			if (classLoader == null) {

				classLoader = getThreadClassLoader();
				if (classLoader == null) {
					throw new ClassNotFoundException();
				} else {
					clazz = classLoader.loadClass(className);
				}
			} else {
				clazz = classLoader.loadClass(className);
			}
		} catch (ClassNotFoundException e1) {
			try {
				// CurrentClassLoader
				classLoader = getCurrentClassLoader();
				clazz = Class.forName(className, true, classLoader);
			} catch (ClassNotFoundException e) {
				throw e;
			}
		}
		debugClassLoader(clazz, className, classLoader);
		return clazz;
	}

    // ----------------------------------------------------------------------
    // Tools
    // ----------------------------------------------------------------------

	/**
	 * @param clazz
	 * @param className
	 */
	private static void debugClassLoader(Class<?> clazz, String className, ClassLoader classLoader) {
		if(clazz!=null)
			System.out.println("Class:" + clazz.getName() + " load by "  + classLoader);
		else
			System.out.println("Class:" + className + " cannot load by ClassLoader.");
	}	

	/**
	 * @param args
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		System.out.println("BootstrapLoader:"   + ClassLoaderUtils.getBootstrapLoader());
		System.out.println("ExtClassLoader:"    + ClassLoaderUtils.getExtClassLoader());
		System.out.println("AppClassLoader:"    + ClassLoaderUtils.getAppClassLoader());
		System.out.println("ThreadClassLoader:" + ClassLoaderUtils.getThreadClassLoader());
		
		System.out.println("\nHierarchy-ClassLoadersDesc:");
		ClassLoaderUtils.printHierarchyClassLoadersDesc();
	}
}
