package com.company.coupling.polymorphism;


public class SonySpeaker implements Speaker{
	//������
	public SonySpeaker() {
		System.out.println("===> SonySpeaker ��ü ����");
	}
	
	public void volumeUp() {
		System.out.println("SonySpeaker ===> ���� �ø���.");
	}
	
	public void volumeDown() {
		System.out.println("SonySpeaker ===> ���� ������.");
	}
}
