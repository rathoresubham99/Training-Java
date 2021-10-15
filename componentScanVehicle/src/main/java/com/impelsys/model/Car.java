package com.impelsys.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.impelsys.model.Engine;

@Component
public class Car {
	@Value("Luxury")
	String type;
	@Value("BMW")
	String model;
   @Autowired
	Engine engine;
	
	public Car() {
		super();
	}
	public Car(String type, String model, Engine engine) {
		super();
		this.type = type;
		this.model = model;
		this.engine = engine;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
//    @Autowired
	public void setModel(String model) {
    	System.out.println("Setting Model name...");
		this.model = model;
	}
	public Engine getEngine() {
		return engine;
	}
   
	public void setEngine(Engine engine) {
     	System.out.println("Setting Engine type...");
		this.engine = engine;
	}
	@Override
	public String toString() {
		return "Car [type=" + type + ", model=" + model + ", engine=" + engine + "]";
	}
	
	
}
