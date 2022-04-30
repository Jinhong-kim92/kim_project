package com.company.coupling.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * ���� Ŭ����
 * �� ���α׷��� �� ���� ������
 * (1) SonySpeaker ��ü�� ���� ���� �� ���� �����Ǵ� ���̰�
 * (2) ��������� SonySpeaker�� ������ �������� AppleSpeaker�� �����ϰ��� �� ��,
 *     volumnUp(), volumnDown() �� ���� �޼ҵ带 ��� �����ؾ� �Ѵ�.
 * [���] ���� �� ���� �������� �ذ��ϴ� ����� => DI�� ����    
 */
@Component("tv")   //Component ������̼�
public class SamsungTV implements TV{  //Ŭ���� �����
	//�߰� => ����
	@Resource(name="apple")
	private Speaker speaker;		//Speaker ��ü �ν��Ͻ� ��������
	private int price;    			//����
	
	//�⺻ ������	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) ��ü ����");
	}
	/*
	 * stter ������ �� => setter �������� �����Ϸ��� �⺻ �����ڵ� �ݵ�� �ʿ��ϴ�.
	 */
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() �޼ҵ� ȣ��");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() �޼ҵ� ȣ��");
		this.price = price;
	}
	
	
	/**
	 * [�߿�] ������ �����Ƕ�?
	 * �������� �����ڰ� � Ŭ������ ��ü�� �ʿ��ϸ� �� Ŭ������ �����ڸ� ���ؼ� ��ü ���� ��
	 * �� Ŭ������ �޼ҵ� ȣ���ߴ�.
	 * �׷��� ������ �����ӿ�ũ��  ������ ȯ�� ���� ������ applicationContext.xml��
	 * ��ü�� <bean>�� ��� ���� ������ ������ �����̳ʰ� �ڵ����� ��ü�� �����Ͽ� �ٸ� Ŭ��������
	 * � Ŭ������ ��ü�� �ʿ��ϸ� ������ �������� ���ؼ� ����(injection) ��Ų��.
	 * 	
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) ��ü ����");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) ��ü ����");
		this.speaker = speaker;
		this.price = price;
	}
	*/
	//�޼ҵ� �ñ״��İ� ����
	@Override   //������̼�
	public void powerOn() {
		System.out.println("SamsungTV ===> ������ �Ҵ�. (���� : " + price + "��"+")");		
	}

	



	@Override
	public void volumnUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	@Override
	public void volumnDown() {
		//speaker = new SonySpeaker();
		speaker.volumeDown();		
	}

	@Override
	public void powerDown() {
		System.out.println("SamsungTV ===> ������ ����.");		
	}
}
