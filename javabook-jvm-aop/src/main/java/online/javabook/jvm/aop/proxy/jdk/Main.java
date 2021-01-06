package online.javabook.jvm.aop.proxy.jdk;

import online.javabook.jvm.aop.proxy.BusinessService;
import online.javabook.jvm.aop.proxy.IBusinessService;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        BusinessServiceLoggerJDKProxy businessServiceLoggerProxy = new BusinessServiceLoggerJDKProxy();
        IBusinessService businessServiceProxy = businessServiceLoggerProxy.proxy(BusinessService.class);

        businessServiceProxy.doSomething1();
        System.out.println();
        businessServiceProxy.doSomething2();

        System.out.println();
        System.out.println("businessServiceProxy.getClass().getName() -> " + businessServiceProxy.getClass().getName());
    }
}
