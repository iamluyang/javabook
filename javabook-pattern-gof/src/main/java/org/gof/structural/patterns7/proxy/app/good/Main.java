package org.gof.structural.patterns7.proxy.app.good;

import org.gof.structural.patterns7.proxy.logger.BusinessService;
import org.gof.structural.patterns7.proxy.logger.IBusinessService;
import org.gof.structural.patterns7.proxy.logger.BusinessServiceLoggerProxy;

public class Main {
    public static void main(String[] args) {
        IBusinessService businessService = new BusinessService();
        IBusinessService loggerProxy = new BusinessServiceLoggerProxy(businessService);
        loggerProxy.doSomething();
    }
}
