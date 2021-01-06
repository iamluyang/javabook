package online.javabook.jvm.aop.proxy.aspectj;

import online.javabook.jvm.aop.proxy.BusinessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] ags) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BusinessService businessService = context.getBean(BusinessService.class);

        businessService.doSomething1();
        System.out.println();
        businessService.doSomething2();

        System.out.println();
        System.out.println("businessServiceProxy.getClass().getName() -> " + businessService.getClass().getName());
    }
}
