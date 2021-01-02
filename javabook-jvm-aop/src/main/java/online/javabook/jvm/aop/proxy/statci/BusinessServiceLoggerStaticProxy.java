package online.javabook.jvm.aop.proxy.statci;

import online.javabook.jvm.aop.proxy.IBusinessService;

public class BusinessServiceLoggerStaticProxy implements IBusinessService {

	public IBusinessService businessService;

	public BusinessServiceLoggerStaticProxy(IBusinessService businessService) {
		this.businessService = businessService;
	}

	@Override
	public void doSomething() {
		System.out.println("Log begin.........");

		businessService.doSomething();

		System.out.println("Log finish........");
	}
}
