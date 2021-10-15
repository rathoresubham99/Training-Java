package org.impelsys.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc
@Configuration
@ImportResource({"classpath:beans.xml"})
@ComponentScan(basePackages={"org.impelsys.controller","org.impelsys.model","org.impelsys.data","org.impelsys.service"})
public class SpringHibernateXMLConfig {
	
}
