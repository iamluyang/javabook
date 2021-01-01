package online.javabook.pattern.gof.structural.patterns7.proxy.app.bad;

import online.javabook.pattern.gof.structural.patterns7.proxy.logger.IBusinessService;

public class Main {
    public static void main(String[] args) {
        IBusinessService businessService = new BadBusinessService();
        businessService.doSomething();
    }
}
