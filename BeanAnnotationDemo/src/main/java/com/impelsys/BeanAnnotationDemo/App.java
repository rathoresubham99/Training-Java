package com.impelsys.BeanAnnotationDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.impelsys.config.AppConfig;
import com.impelsys.model.impl.SamsungMobile;

public class App {
public static void main(String[] args )
{
//	SamsungMobile mobile = new SamsungMobile();
//	mobile.config();
	
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	context.registerShutdownHook();
	System.out.println("Eager Loading");
//	SamsungMobile s8= context.getBean(SamsungMobile.class);
//	SamsungMobile s8 = (SamsungMobile) context.getBean("samsungMobile");
//	s8.config();
}
}
