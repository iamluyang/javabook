package online.javabook.jvm.aop.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import online.javabook.jvm.aop.proxy.BusinessService;
import online.javabook.jvm.aop.proxy.IBusinessService;
import online.javabook.jvm.aop.proxy.jdk.BusinessServiceLoggerJDKProxy;

public class Main {
	public static void main(String[] args) {
		BusinessServiceLoggerCglibProxy businessServiceLoggerCglibProxy = new BusinessServiceLoggerCglibProxy();

		IBusinessService businessServiceProxy = businessServiceLoggerCglibProxy.proxy(BusinessService.class);
		businessServiceProxy.doSomething();
	}
}
