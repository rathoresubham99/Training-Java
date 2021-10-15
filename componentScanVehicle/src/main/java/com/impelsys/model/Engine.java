package com.impelsys.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {
	@Value("16 Cylinder Engine")
String engineType;


public void showEngine() {
	System.out.println("The Engine type is :" + this.engineType);

}


@Override
public String toString() {
	return "Engine [engineType=" + engineType + "]";
}


}
