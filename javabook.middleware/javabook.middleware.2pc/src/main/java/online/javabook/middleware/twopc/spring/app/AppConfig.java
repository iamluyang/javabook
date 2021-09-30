package online.javabook.middleware.twopc.spring.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "online.javabook.middleware.twopc.**.**")
@EnableAspectJAutoProxy
public class AppConfig {

}
