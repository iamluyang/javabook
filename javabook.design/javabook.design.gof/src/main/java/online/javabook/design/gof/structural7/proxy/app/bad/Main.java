package online.javabook.design.gof.structural7.proxy.app.bad;

import online.javabook.design.gof.structural7.proxy.logger.IBusinessService;

public class Main {
    public static void main(String[] args) {
        IBusinessService businessService = new BadBusinessService();
        businessService.doSomething1();
        businessService.doSomething2();
    }
}
