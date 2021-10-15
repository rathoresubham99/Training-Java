package com.impelsys.mavenDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mavenDemoProject.Employee;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
System.out.println("Hello World...");
Employee bean = (Employee) context.getBean("empBean");

System.out.println("Emp name: "+ bean.getName() +"  has got "+(bean.getLaptopDevice1()!=null? ( bean.getLaptopDevice1().getModelNum()+" "):"No device is Found!!!"));
bean.setName("Mr. Subham");
Employee bean1 = (Employee) context.getBean("empBean");
System.out.println("Emp Name: "+ bean.getName());

Employee bean2 = (Employee) context.getBean("empBean1");
System.out.println("Emp name: "+ bean2.getName() +"  has got "+ bean2.getLaptopDevice1().getModelNum()+" ");
	}

}
