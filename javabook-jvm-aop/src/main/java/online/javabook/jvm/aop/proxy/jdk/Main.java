package online.javabook.jvm.aop.proxy.jdk;

import online.javabook.jvm.aop.proxy.BusinessService;
import online.javabook.jvm.aop.proxy.IBusinessService;
import online.javabook.jvm.aop.proxy.statci.BusinessServiceLoggerStaticProxy;

public class Main {
    public static void main(String[] args) {
        IBusinessService businessService = new BusinessService();
        BusinessServiceLoggerJDKProxy businessServiceLoggerProxy = new BusinessServiceLoggerJDKProxy();

        IBusinessService businessServiceProxy = businessServiceLoggerProxy.proxy(businessService);
        businessServiceProxy.doSomething();
    }
}
