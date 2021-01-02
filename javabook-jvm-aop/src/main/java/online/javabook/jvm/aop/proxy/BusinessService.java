package online.javabook.jvm.aop.proxy;

public class BusinessService implements IBusinessService {

	@Override
	public void doSomething() {
		System.out.println("Do something");
	}
}
