package online.javabook.jdk.exception.chain;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class ChainClass {

	/**
	 * @throws ChainException3 
	 */
	public void throwChainException() throws ChainException3 {		
		
		try {
			ChainException1 chainException1 = new ChainException1("Hi i am ChainException1.");
			throw chainException1;
			
		} catch (ChainException1 e1) {
			
			try {
				ChainException2 chainException2 = new ChainException2("Hi i am ChainException2.", e1);
				throw chainException2;
				
			} catch (ChainException2 e2) {
				
				ChainException3 chainException3 = new ChainException3("Hi i am ChainException3.", e2);
				throw chainException3;
			}
		}
	}
		
}
