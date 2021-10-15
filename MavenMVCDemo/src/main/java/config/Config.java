package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//replacement for dispatcher-servlet
@Configuration
@ComponentScan({"controller","model"})
public class Config {

	
}
