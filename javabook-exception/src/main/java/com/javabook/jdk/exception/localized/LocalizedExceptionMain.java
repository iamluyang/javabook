package com.javabook.jdk.exception.localized;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class LocalizedExceptionMain {

	public static void main(String[] args) {
		
		LocalizedClass classLocalized = new LocalizedClass();
		try {
			classLocalized.throwLocalizedException();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
