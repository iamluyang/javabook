package org.gof.structural.patterns7.proxy.app.bad;

import org.gof.structural.patterns7.proxy.logger.IBusinessService;

public class BadBusinessService implements IBusinessService {

    @Override
    public void doSomething() {
        System.out.println("Log begin.........");

        System.out.println("Do something");

        System.out.println("Log finish........");
    }
}
