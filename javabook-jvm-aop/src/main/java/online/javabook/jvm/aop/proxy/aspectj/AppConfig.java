package online.javabook.jvm.aop.proxy.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "online.javabook.jvm.aop.**")
@EnableAspectJAutoProxy
public class AppConfig {

}
