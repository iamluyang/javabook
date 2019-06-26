package com.javabook.jdk.exception.localized;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class LocalizedClass {

	/**
	 * @throws LocalizedException 
	 */
	public void throwLocalizedException() throws LocalizedException {		
		
		LocalizedException localizedException = new LocalizedException("Hi i am LocalizedException.");
		throw localizedException;
	}
		
}
