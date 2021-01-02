package online.javabook.jvm.exception.chain;



/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class ChainOfTheExceptionMain {

	public static void main(String[] args) {
		
		ChainClass classChain = new ChainClass();
		try {
			classChain.throwChainException();
		} catch (Throwable e) {
			e.printStackTrace();
			
			Throwable current = e;
			do{
				System.out.println( current.getLocalizedMessage() );
				current = current.getCause();
			}while( current!=null );

		}
	}
}
