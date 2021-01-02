package online.javabook.exception.asserts;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class AssertMain {

	public static void main(String[] args) {
		
		System.out.println("before assert");
		
		//if((10%1)==0){
			assert(true);
		//}else{
			assert(false);
		//}
		
		System.out.println("after assert");
	}
}
