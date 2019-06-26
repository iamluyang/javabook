/**
 * 
 */
package com.javabook.jdk.exception.localized;

import java.util.ListResourceBundle;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class ExceptionResourceBundle extends ListResourceBundle {

	private Object[][] contents = new Object[][]{
		{"name", "description"}
	};
	
	/* (non-Javadoc)
	 * @see java.util.ListResourceBundle#getContents()
	 */
	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
