package online.javabook.pattern.gof.structural.patterns7.proxy.app.good;

import online.javabook.pattern.gof.structural.patterns7.proxy.logger.BusinessService;
import online.javabook.pattern.gof.structural.patterns7.proxy.logger.BusinessServiceLoggerProxy;
import online.javabook.pattern.gof.structural.patterns7.proxy.logger.IBusinessService;

public class Main {
    public static void main(String[] args) {
        IBusinessService businessService = new BusinessService();
        IBusinessService loggerProxy = new BusinessServiceLoggerProxy(businessService);
        loggerProxy.doSomething();
    }
}
