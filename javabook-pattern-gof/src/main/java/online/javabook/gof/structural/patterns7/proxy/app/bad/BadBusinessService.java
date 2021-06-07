package online.javabook.gof.structural.patterns7.proxy.app.bad;

import online.javabook.gof.structural.patterns7.proxy.logger.IBusinessService;

public class BadBusinessService implements IBusinessService {

    @Override
    public void doSomething1() {
        System.out.println("Log begin.........");

        System.out.println("Do something1");

        System.out.println("Log finish........");
    }

    @Override
    public void doSomething2() {
        System.out.println("Log begin.........");

        System.out.println("Do something2");

        System.out.println("Log finish........");
    }
}
