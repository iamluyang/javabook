package org.gof.structural.patterns7.proxy.logger;

public class BusinessService implements IBusinessService {

    @Override
    public void doSomething() {
        System.out.println("Do something");
    }
}
