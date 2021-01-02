package online.javabook.exception.collection;

import online.javabook.exception.profile.ExceptionProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class CollectionExceptionMain {

	public static void main(String[] args) {
		
		ExceptionProfile testProfile = new ExceptionProfile();
		long total = 5000000;
		
		List lista = new ArrayList();		
		testProfile.start();
		for(int count=0; count<total; count++){
			lista.add(new Element());
		}
		testProfile.stop("lista", total);	
				
		List<Element> listb = new ArrayList<Element>();
		testProfile.start();
		for(int count=0; count<total; count++){
			listb.add(new Element());
		}
		testProfile.stop("listb", total);

	}
}
