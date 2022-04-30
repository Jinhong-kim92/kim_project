package com.company.coupling.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		//1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext factory 
		      = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring �����̳ʷ� �ʿ��� ��ü�� ��û(Lookup)�Ѵ�.
		TV tv = (TV)factory.getBean("tv");		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerDown();
		
		//3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();
	}
}




