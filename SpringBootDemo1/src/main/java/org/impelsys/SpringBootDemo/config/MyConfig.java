package org.impelsys.SpringBootDemo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.impelsys.SpringBootDemo.resources.MessageResource;
import org.impelsys.SpringBootDemo.resources.UserResource;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MyConfig extends ResourceConfig{
	
	public MyConfig() {
		register(MessageResource.class);
		register(UserResource.class);
	}
}
