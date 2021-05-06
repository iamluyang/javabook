package online.javabook.pattern.gof.structural.patterns7.proxy.logger;

public class BusinessServiceLoggerProxy implements IBusinessService {

    public IBusinessService businessService;

    public BusinessServiceLoggerProxy(IBusinessService businessService) {
        this.businessService = businessService;
    }

    @Override
    public void doSomething() {
        System.out.println("Log begin.........");

        businessService.doSomething();

        System.out.println("Log finish........");
    }
}
