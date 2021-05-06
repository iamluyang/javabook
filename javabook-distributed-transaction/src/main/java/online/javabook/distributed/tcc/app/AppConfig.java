package online.javabook.distributed.tcc.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "online.javabook.distributed.tcc.**.**")
@EnableAspectJAutoProxy
public class AppConfig {

}
