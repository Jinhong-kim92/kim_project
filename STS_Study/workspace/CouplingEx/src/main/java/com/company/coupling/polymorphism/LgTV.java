package com.company.coupling.polymorphism;

public class LgTV implements TV{
	//�޼ҵ� �ñ״��İ� ����
	@Override
	public void powerOn() {
		System.out.println("LgTV ===> ������ �Ҵ�.");		
	}

	@Override
	public void volumnUp() {
		System.out.println("LgTV ===> ������ �ø���.");			
	}

	@Override
	public void volumnDown() {
		System.out.println("LgTV ===> ������ ������.");			
	}

	@Override
	public void powerDown() {
		System.out.println("LgTV ===> ������ ����.");		
	}
}
