package online.javabook.exception.profile;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class ExceptionProfileClass {

	/**
	 * @param value
	 * @return
	 */
	public int getIntNothing(String value) {
		int number = 0;
		number = Integer.parseInt(value);
		return number;	
	}
	
	/**
	 * @param value
	 * @return
	 */
	public int getIntTryCatch(String value) {
		int number = 0;
		try {
			number = Integer.parseInt(value);
		} catch (NumberFormatException e) {
		}
		return number;	
	}
	
	/**
	 * @param value
	 * @return
	 * @throws NumberFormatException
	 */
	public int getIntDeclare(String value) throws NumberFormatException{
		int number = 0;
		number = Integer.parseInt(value);
		return number;	
	}
}
