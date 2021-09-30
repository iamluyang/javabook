package online.javabook.design.gof.structural7.proxy.logger;

public class BusinessServiceLoggerProxy implements IBusinessService {

    public IBusinessService businessService;

    public BusinessServiceLoggerProxy(IBusinessService businessService) {
        this.businessService = businessService;
    }

    @Override
    public void doSomething1() {
        System.out.println("Log begin.........");

        businessService.doSomething1();

        System.out.println("Log finish........");
    }

    @Override
    public void doSomething2() {
        System.out.println("Log begin.........");

        businessService.doSomething2();

        System.out.println("Log finish........");
    }
}
