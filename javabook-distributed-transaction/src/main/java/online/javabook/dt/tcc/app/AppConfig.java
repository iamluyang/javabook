package online.javabook.dt.tcc.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "online.javabook.dt.tcc.**.**")
@EnableAspectJAutoProxy
public class AppConfig {

}
