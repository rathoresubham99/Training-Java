package com.impelsys.model.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.impelsys.model.Mobile;
import com.impelsys.model.Processor;
//@Component
public class SamsungMobile implements Mobile {
@Autowired
Processor processor;
public SamsungMobile() {

	System.out.println("Inside constructor...");
}
	public void config() {
		// TODO Auto-generated method stub
		System.out.println("Quad Core Processor, 12MP Camera, 8GB RAM.");
		processor.config();
	}
	
	

 //init method
	@PostConstruct
	public void init()
	{
		System.out.println("Initializing the samsung mobile..");
		
	}
	
	
//	public void preInit()
//	{
//		System.out.println("Initializing the samsung mobile..");
//		
//	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("Doing cleaning activities before Destroying the samsung mobile..");
	}
}
