package com.company.coupling.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory 
		      = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로 필요한 객체를 요청(Lookup)한다.
		TV tv = (TV)factory.getBean("tv");		
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerDown();
		
		//3. Spring 컨테이너를 종료한다.
		factory.close();
	}
}




