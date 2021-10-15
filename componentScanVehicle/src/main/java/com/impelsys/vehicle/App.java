package com.impelsys.vehicle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.impelsys.model.Car;

public class App {
	public static void main(String args[])
	{

		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 Car car = (Car) context.getBean("car");
		 System.out.println(car);
	}
}
