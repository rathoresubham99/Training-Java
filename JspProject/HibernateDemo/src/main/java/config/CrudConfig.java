package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc//enables spring MVC
//@ImportResource("classpath:dispatcherServlet-servlet.xml")
@Configuration
@ComponentScan({"controller","model","service","dao"})
public class CrudConfig {
	
	@Bean
	public ViewResolver configureViewResolver(){
		System.out.println("In configureViewResolver!!!!!!!!!!!!");
		InternalResourceViewResolver viewResolve=new InternalResourceViewResolver();
		viewResolve.setPrefix("/WEB-INF/jsp/");
		viewResolve.setSuffix(".jsp");
		
		return viewResolve;
	}
}
