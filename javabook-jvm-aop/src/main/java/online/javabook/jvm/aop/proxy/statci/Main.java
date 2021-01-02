package online.javabook.jvm.aop.proxy.statci;

import online.javabook.jvm.aop.proxy.BusinessService;
import online.javabook.jvm.aop.proxy.IBusinessService;

public class Main {
    public static void main(String[] args) {
        IBusinessService businessService = new BusinessService();
        IBusinessService businessServiceLoggerProxy = new BusinessServiceLoggerStaticProxy(businessService);

        businessServiceLoggerProxy.doSomething();
    }
}
