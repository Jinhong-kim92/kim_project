package com.company.coupling;

/*
 * ���� Ŭ���� => main() �޼ҵ尡 ���Ե� Ŭ����
 */
public class TVUser {
	public static void main(String[] args) {		
		
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}
}
