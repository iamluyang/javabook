package online.javabook.jvm.aop.proxy.statci;

import online.javabook.jvm.aop.service.BusinessService;
import online.javabook.jvm.aop.service.IBusinessService;

public class Main {
    public static void main(String[] args) {
        IBusinessService businessService = new BusinessService();
        IBusinessService businessServiceProxy = new BusinessServiceLoggerStaticProxy(businessService);

        businessServiceProxy.doSomething1();
        System.out.println();
        businessServiceProxy.doSomething2();

        System.out.println();
        System.out.println("businessServiceProxy.getClass().getName() -> " + businessServiceProxy.getClass().getName());
    }
}
