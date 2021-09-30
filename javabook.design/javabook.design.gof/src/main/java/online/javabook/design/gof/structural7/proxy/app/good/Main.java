package online.javabook.design.gof.structural7.proxy.app.good;

import online.javabook.design.gof.structural7.proxy.logger.BusinessServiceLoggerProxy;
import online.javabook.design.gof.structural7.proxy.logger.IBusinessService;
import online.javabook.design.gof.structural7.proxy.logger.BusinessService;

public class Main {
    public static void main(String[] args) {
        IBusinessService businessService = new BusinessService();
        IBusinessService loggerProxy = new BusinessServiceLoggerProxy(businessService);
        loggerProxy.doSomething1();
        loggerProxy.doSomething2();
    }
}
