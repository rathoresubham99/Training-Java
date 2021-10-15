package com.impelsys.model.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.impelsys.model.Processor;

@Component
@Primary
public class OctacoreProcessor implements Processor {

	public void config() {
		// TODO Auto-generated method stub
System.out.println("This is an octacore processor...");
	}

}
