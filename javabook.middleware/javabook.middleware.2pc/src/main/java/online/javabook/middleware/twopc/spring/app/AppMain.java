package online.javabook.middleware.twopc.spring.app;

import online.javabook.middleware.twopc.service.api.IMasterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IMasterService masterService = context.getBean(IMasterService.class);

        masterService.doBusiness(1, 100);
    }
}
