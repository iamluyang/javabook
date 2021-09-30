package online.javabook.jdk.exception.java;

import java.io.UnsupportedEncodingException;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class StringExceptionMain {

	public static void main(String[] args) {

		// java.io.UnsupportedEncodingException		
		try {
			String gbkString = new String("ол╣Щ".getBytes(), "GBK");
			String badString = new String(gbkString.getBytes(), "BAD_charsetName");			
			System.out.println(badString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		
		// java.lang.NullPointerException
		try {
			StringBuffer nullPointerString = new StringBuffer(null);
			System.out.println(nullPointerString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// java.lang.NegativeArraySizeException
		try {
			StringBuffer negativeArraySizeString = new StringBuffer(-1);
			System.out.println(negativeArraySizeString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} 
