package com._interface.practice;

/*
 * 인터페이스 
 *  - 인터페이스는 개발 코드와 객체가 서로 통신하는 접점 이다
 *  - 필드는 무조건 상수 = public static final 생략 가능
 *  - 메서드는 무고건 추상메서드 = public abstract 생략 가능
 *  - 인터페이스를 구현 하기 위서는 implements 키워드를 이용한다
 *  - 인터페이스는 다중 상속이 가능하다
 *  
 * 추상클래스와 인터페이스
 *  - 공통점
 *  	🍀 객체 생성이 안된다!
 *  	🍀 참조변수의 타입으로 사용 할 수 있다 = 형변환이 가능하다
 *  	🍀 상속(추상클래스), 구현(인터페이스)하는 클래스에서 추상메서드를 구현 해야 한다
 *  		미구현시 추상클래스로 만들어 줘야 합니다.
 *  
 *  - 차이점
 *   	🍀 추상클래스는 abstract 키워드로 정의 , 필드, 메서드, 추상메서드를 가질 수 있다
 *   	🍀 인터페이스는 interface 키워드로 정의, 상수, 추상메서드만 가질 수 있다
 *   	8~9버전 이후 default 메서드와 static 메서드가 사용 가능 하게 되었다
 *   	추상 클래스는 추상 클래스를 상속 받아서 클래스를 확장하는데 목적이 있고
 *   	인터페이스는 클래스의 기능을 강제 구현 하는데 있다!!
 */
public interface Remote {
	
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 인터페이스에서 메서드는 무조건 추상 메서드 이다
	public abstract void turnOn();
	/*public abstract*/void turnOff();
	
	default int volumeUp(int volume) {
		if(volume >= 10) {
			System.out.println("최대 볼륨 입니다.");
		} else {
			volume++;
		}
		return volume;
	}
	
	default int volumeDown(int volume) {
		if(volume <= 0) {
			System.out.println("최소 볼륨 입니다.");
		} else {
			volume--;
		}
		return volume;
	}
	
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교체 합니다.");
	}
	
//	private String test(){
//		
//	}

}
