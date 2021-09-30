package online.javabook.jvm.aop.proxy.aspectj;

import online.javabook.jvm.aop.service.IBusinessService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] ags) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IBusinessService businessService = context.getBean(IBusinessService.class);

        businessService.doSomething1();
        System.out.println();
        businessService.doSomething2();

        System.out.println();
        System.out.println("businessServiceProxy.getClass().getName() -> " + businessService.getClass().getName());
        System.out.println("businessServiceProxy.getClass().getSuperclass() -> " + businessService.getClass().getSuperclass());
        System.out.println("businessServiceProxy.getClass().getInterfaces()[0] -> " + businessService.getClass().getInterfaces()[0]);
    }
}
