/**
 * 
 */
package online.javabook.jdk.exception.localized;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class LocalizedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3763313002830582273L;

	/**
	 * DEFAULT_MESSAGE_KEY
	 */
	public static String DEFAULT_MESSAGE_KEY = "name";
	
	/**
	 * messageKey
	 */
	private String messageKey = DEFAULT_MESSAGE_KEY;
	
	/**
	 * language
	 */
	private String language;
	
	/**
	 * country
	 */
	private String country;

	/**
	 * @param message
	 */
	public LocalizedException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @param messageKey
	 */
	public LocalizedException(Throwable cause, String messageKey) {
		super(cause);
		
		if(isValidString(messageKey)) this.messageKey = messageKey;
	}
	
	/**
	 * @param message
	 * @param cause
	 * @param messageKey
	 */
	public LocalizedException(String message, Throwable cause, String messageKey) {
		super(message, cause);
		
		if(isValidString(messageKey)) this.messageKey = messageKey;
	}

	/**
	 * @param message
	 * @param cause
	 * @param messageKey
	 * @param language
	 * @param country
	 */
	public LocalizedException(String message, Throwable cause, String messageKey, String language, String country) {
		super(message, cause);
		
		if(isValidString(messageKey)) this.messageKey = messageKey;
		
		if(isValidString(language))   this.language   = language;
		
		if(isValidString(country))    this.country    = country;
	}
	
	/**
	 * @return the localMessageKey
	 */
	public String getLocalMessageKey() {
		return messageKey;
	}

	/**
	 * @param messageKey the localMessageKey to set
	 */
	public void setLocalMessageKey(String messageKey) {
		if(isValidString(messageKey)) this.messageKey = messageKey;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getLocalizedMessage()
	 */
	public String getLocalizedMessage() {
		
		ResourceBundle resourceBundle = null;
		Locale locale = getLocale();
		resourceBundle = ResourceBundle.getBundle("com.javabook.jdk.exception.localized.ExceptionResourceBundle", locale);
		return resourceBundle.getString(messageKey);
	}
	
	/**
	 * @return
	 */
	private Locale getLocale() {
		
		Locale locale = Locale.getDefault();
		
		if(this.language!=null && this.country!=null){
			locale = new Locale(language, country);
			
		}else if(this.language!=null){
			locale = new Locale(language);
		}
		return locale;
	}
	
	/**
	 * @param messageKey
	 * @return
	 */
	private boolean isValidString(String messageKey){
		return messageKey!=null && !messageKey.equalsIgnoreCase("");
	}
}
