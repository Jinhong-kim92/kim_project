package com.company.coupling.factorypattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.coupling.polymorphism.Speaker;

@Component("tv")
public class LgTV implements TV{
	@Autowired    //Autowired 어노테이션
	private Speaker speaker;		//Speaker 객체 인스턴스 참조변수
	private int price;    			//가격
	
	//기본 생성자	
	public LgTV() {
		System.out.println("===> LgTV(1) 객체 생성");
	}
	//메소드 시그니쳐가 동일
	@Override
	public void powerOn() {
		System.out.println("LgTV ===> 전원을 켠다.");		
	}

	@Override
	public void volumnUp() {
		System.out.println("LgTV ===> 볼륨을 올린다.");			
	}

	@Override
	public void volumnDown() {
		System.out.println("LgTV ===> 볼륨을 내린다.");			
	}

	@Override
	public void powerDown() {
		System.out.println("LgTV ===> 전원을 끈다.");		
	}
}
