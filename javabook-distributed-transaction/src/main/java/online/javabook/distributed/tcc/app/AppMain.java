package online.javabook.distributed.tcc.app;

import online.javabook.distributed.tcc.example.IMasterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IMasterService masterService = context.getBean(IMasterService.class);

        masterService.doBusiness(1, 100);
    }
}
