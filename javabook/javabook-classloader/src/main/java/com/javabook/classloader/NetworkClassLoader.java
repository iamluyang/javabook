package com.javabook.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import com.javabook.classloader.service.api.ISimpleService;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class NetworkClassLoader extends ClassLoader {
	
	/**
	 * url
	 */
	private String url;
	
	/**
	 * @param url
	 */
	public NetworkClassLoader(String url) {
		this.url = url;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		}
		else {
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
			URL url = new URL(path);
			
			// io
			InputStream  is = new BufferedInputStream(url.openStream());
			OutputStream os = new ByteArrayOutputStream();
			
			// buffer
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			
			// read/write
			int bytesNumRead = 0;
			while ((bytesNumRead = is.read(buffer)) != -1) {
				os.write(buffer, 0, bytesNumRead);
			}
			
			// toByteArray
			return ((ByteArrayOutputStream)os).toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * @param className
	 * @return
	 */
	private String classNameToPath(String className) {
		return url + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			// URL
			String urls = "file:\\E:\\workshop\\J2EE\\workshop_book\\book_classloader\\mybin";

			// networkClassLoader
			NetworkClassLoader networkClassLoader = new NetworkClassLoader(urls);

			// simpleServiceLowerCaseImpl
			String simpleServiceLowerCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceLowerCaseImpl";

			// simpleServiceLowerCaseImplClass1
			Class<?> simpleServiceLowerCaseImplClass1 = networkClassLoader.loadClass(simpleServiceLowerCaseImpl);
			ISimpleService simpleService1 = (ISimpleService) simpleServiceLowerCaseImplClass1.newInstance();
			
			System.out.println(	simpleServiceLowerCaseImplClass1.getName()+":"+simpleServiceLowerCaseImplClass1.getClassLoader() );

			// simpleServiceUpperCaseImpl
			String simpleServiceUpperCaseImpl = "com.javabook.classloader.service.impl.SimpleServiceUpperCaseImpl";		
			
			// simpleServiceUpperCaseImplClass1
			Class<?> simpleServiceUpperCaseImplClass1 = networkClassLoader.loadClass(simpleServiceUpperCaseImpl);
			ISimpleService simpleServiceUpperCaseImpl1 = (ISimpleService) simpleServiceUpperCaseImplClass1.newInstance();
			
			System.out.println(	simpleServiceUpperCaseImplClass1.getName()+":"+simpleServiceUpperCaseImplClass1.getClassLoader() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
