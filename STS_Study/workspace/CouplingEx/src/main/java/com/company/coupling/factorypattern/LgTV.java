package com.company.coupling.factorypattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.coupling.polymorphism.Speaker;

@Component("tv")
public class LgTV implements TV{
	@Autowired    //Autowired ������̼�
	private Speaker speaker;		//Speaker ��ü �ν��Ͻ� ��������
	private int price;    			//����
	
	//�⺻ ������	
	public LgTV() {
		System.out.println("===> LgTV(1) ��ü ����");
	}
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
