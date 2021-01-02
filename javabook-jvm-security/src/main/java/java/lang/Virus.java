package java.lang;

public class Virus {

	public void whoAmI() {		
		System.out.println("I am " + this.getClass() + 
		", load by [" + this.getClass().getClassLoader() + "]");
	}
}
