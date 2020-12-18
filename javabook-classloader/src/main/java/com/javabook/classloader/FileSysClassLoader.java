package com.javabook.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.javabook.classloader.service.api.ISimpleService;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class FileSysClassLoader extends ClassLoader {

	/**
	 * classPath
	 */
	private String classPath;

	/**
	 * @param classPath
	 */
	public FileSysClassLoader(String classPath) {
		this.classPath = classPath;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {

		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	/**
	 * @param className
	 * @return
	 */
	private byte[] getClassData(String className) {

		String path = classNameToPath(className);
		try {
			
			// io
			InputStream  is = new BufferedInputStream( new FileInputStream(path) );
		
			// os
			OutputStream os = new ByteArrayOutputStream();

			// buffer
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];

			// read/write
			int bytesNumRead = 0;
			while ((bytesNumRead = is.read(buffer)) != -1) {
				os.write(buffer, 0, bytesNumRead);
			}
			
			// flush
			os.flush();
			
			// toByteArray
			return ((ByteArrayOutputStream)os).toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @param className
	 * @return
	 */
	private String classNameToPath(String className) {
		return classPath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			// File
			String file = "C:\\mybin\\service.jar!";

			// fileSystemClassLoader
			FileSysClassLoader fileSysClassLoader = new FileSysClassLoader(file);

			// ----------------------------------------------------------------------------------------------------
			// SimpleServiceLowerCaseImpl		
			// ----------------------------------------------------------------------------------------------------
	
			// simpleServiceLowerCaseImpl
			String simpleServiceLowerCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceLowerCaseImpl";

			// simpleServiceLowerCaseImplClass2
			Class<?> simpleServiceLowerCaseImplClass2 = fileSysClassLoader.loadClass(simpleServiceLowerCaseImpl);
			ISimpleService simpleServiceLowerCaseImpl2 = (ISimpleService) simpleServiceLowerCaseImplClass2.newInstance();
			
			System.out.println(	simpleServiceLowerCaseImplClass2.getName()+":"+simpleServiceLowerCaseImplClass2.getClassLoader() );

			// ----------------------------------------------------------------------------------------------------
			// SimpleServiceUpperCaseImpl		
			// ----------------------------------------------------------------------------------------------------
	
			// simpleServiceUpperCaseImpl
			String simpleServiceUpperCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceUpperCaseImpl";		

			Class<?> simpleServiceUpperCaseImplClass2 = fileSysClassLoader.loadClass(simpleServiceUpperCaseImpl);
			ISimpleService simpleServiceUpperCaseImpl2 = (ISimpleService) simpleServiceUpperCaseImplClass2.newInstance();
			
			System.out.println(	simpleServiceUpperCaseImplClass2.getName()+":"+simpleServiceUpperCaseImplClass2.getClassLoader() );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
