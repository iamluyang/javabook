package online.javabook.exception.profile;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class ExceptionProfileMain {

	public static void main(String[] args) {
		
		ExceptionProfile      exceptionProfile      = new ExceptionProfile();
		ExceptionProfileClass exceptionProfileClass = new ExceptionProfileClass();
		String                right                 = "1";
		String                wrong                 = "A";
		long                  total                 = 100000000;
		
		// getIntNothing-right
		exceptionProfile.start();
		for(int count=0; count<total; count++){			
			exceptionProfileClass.getIntNothing(right);
		}
		exceptionProfile.stop("getIntNothing-right", total);
		
		// getIntNothing-wrong
		exceptionProfile.start();
		for(int count=0; count<total; count++){			
			try {
				exceptionProfileClass.getIntNothing(wrong);
			} catch (Exception e) {
			}
		}
		exceptionProfile.stop("getIntNothing-wrong", total);
		
		// getIntTryCatc-right
		exceptionProfile.start();
		for(int count=0; count<total; count++){			
			exceptionProfileClass.getIntTryCatch(right);
		}
		exceptionProfile.stop("getIntTryCatc-right", total);

		// getIntTryCatc-wrong
		exceptionProfile.start();
		for(int count=0; count<total; count++){			
			try {
				exceptionProfileClass.getIntTryCatch(wrong);
			} catch (Exception e) {
			}
		}
		exceptionProfile.stop("getIntTryCatc-wrong", total);
		
		// getIntDeclare-right
		exceptionProfile.start();
		for(int count=0; count<total; count++){			
			exceptionProfileClass.getIntDeclare(right);
		}
		exceptionProfile.stop("getIntDeclare-right", total);		

		// getIntDeclare-wrong
		exceptionProfile.start();
		for(int count=0; count<total; count++){			
			try {
				exceptionProfileClass.getIntDeclare(wrong);
			} catch (Exception e) {
			}
		}
		exceptionProfile.stop("getIntDeclare-wrong", total);			
	}
}
