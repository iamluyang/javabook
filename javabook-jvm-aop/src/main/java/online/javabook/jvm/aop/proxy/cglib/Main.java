package online.javabook.jvm.aop.proxy.cglib;

import online.javabook.jvm.aop.service.BusinessService;
import online.javabook.jvm.aop.service.IBusinessService;

public class Main {
	public static void main(String[] args) {
		BusinessServiceLoggerCglibProxy businessServiceLoggerCglibProxy = new BusinessServiceLoggerCglibProxy();
		IBusinessService businessServiceProxy = businessServiceLoggerCglibProxy.proxy(BusinessService.class);

		businessServiceProxy.doSomething1();
		System.out.println();
		businessServiceProxy.doSomething2();

		System.out.println();
		System.out.println("businessServiceProxy.getClass().getName() -> " + businessServiceProxy.getClass().getName());
		System.out.println("businessServiceProxy.getClass().getSuperclass() -> " + businessServiceProxy.getClass().getSuperclass());
		System.out.println("businessServiceProxy.getClass().getInterfaces()[0] -> " + businessServiceProxy.getClass().getInterfaces()[0]);
	}
}
