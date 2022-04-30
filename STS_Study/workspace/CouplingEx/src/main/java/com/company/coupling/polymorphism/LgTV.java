package com.company.coupling.polymorphism;

public class LgTV implements TV{
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
