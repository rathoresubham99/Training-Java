package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//replacement for dispatch servlet xml
@Configuration
@ComponentScan({"controller","model"})
public class MvcConfig {

}
