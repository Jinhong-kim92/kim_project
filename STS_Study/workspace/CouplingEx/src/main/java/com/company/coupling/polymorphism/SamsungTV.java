package com.company.coupling.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * 구현 클래스
 * 이 프로그램의 두 가지 문제점
 * (1) SonySpeaker 객체가 쓸데 없이 두 개나 생성되는 것이고
 * (2) 운영과정에서 SonySpeaker의 성능이 떨어져서 AppleSpeaker로 변경하고자 할 때,
 *     volumnUp(), volumnDown() 두 개의 메소드를 모두 수정해야 한다.
 * [결론] 위의 두 가지 문제점을 해결하는 방법은 => DI를 적용    
 */
@Component("tv")   //Component 어노테이션
public class SamsungTV implements TV{  //클래스 선언부
	//추가 => 수정
	@Resource(name="apple")
	private Speaker speaker;		//Speaker 객체 인스턴스 참조변수
	private int price;    			//가격
	
	//기본 생성자	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	/*
	 * stter 인젝션 예 => setter 인젝션이 동작하려면 기본 생성자도 반드시 필요하다.
	 */
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 메소드 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 메소드 호출");
		this.price = price;
	}
	
	
	/**
	 * [중요] 생성자 인젝션란?
	 * 이전에는 개발자가 어떤 클래스의 객체가 필요하면 그 클래스의 생성자를 통해서 객체 생성 후
	 * 그 클래스의 메소드 호출했다.
	 * 그러나 스프링 프레임워크는  스프링 환경 설정 파일인 applicationContext.xml에
	 * 객체를 <bean>에 등록 시켜 놓으면 스프링 컨테이너가 자동으로 객체를 생성하여 다른 클래스에서
	 * 어떤 클래스의 객체가 필요하면 생성자 인젝션을 통해서 주입(injection) 시킨다.
	 * 	
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	*/
	//메소드 시그니쳐가 동일
	@Override   //어노테이션
	public void powerOn() {
		System.out.println("SamsungTV ===> 전원을 켠다. (가격 : " + price + "원"+")");		
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
		System.out.println("SamsungTV ===> 전원을 끈다.");		
	}
}
