package online.javabook.jvm.exception.localized;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
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
