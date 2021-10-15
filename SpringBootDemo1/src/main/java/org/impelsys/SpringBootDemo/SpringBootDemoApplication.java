package org.impelsys.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages={"org.impelsys.controller" , "org.impelsys.resources","org.impelsys.config"})
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path", "/SpringBootDemo");
		SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("Hello to the world of springBoot");
	}

}
