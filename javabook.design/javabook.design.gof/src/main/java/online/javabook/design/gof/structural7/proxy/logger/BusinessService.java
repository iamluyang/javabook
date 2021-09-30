package online.javabook.design.gof.structural7.proxy.logger;

public class BusinessService implements IBusinessService {

    @Override
    public void doSomething1() {
        System.out.println("Do something1");
    }

    @Override
    public void doSomething2() {
        System.out.println("Do something2");
    }
}
