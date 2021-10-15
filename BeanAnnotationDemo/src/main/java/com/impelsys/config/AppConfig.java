package com.impelsys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.impelsys.model.Processor;
import com.impelsys.model.impl.QuadcoreProcessor;
import com.impelsys.model.impl.SamsungMobile;

//@Configuration
//@ComponentScan("com.impelsys.model.impl")
public class AppConfig {

//	@Lazy // for lazy loading of the beans
	@Bean
public SamsungMobile createSamsungPhone()
{
	return new SamsungMobile();
}
	@Bean
	public Processor createQuadcoreProcessor() {
		return new QuadcoreProcessor();
	}
}
