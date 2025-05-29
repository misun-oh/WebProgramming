package com.polymorphism.practice;

/*
 * 추상 클래스
 * 	- 생성이 불가능, 부모 클래스 역할
 *  - 필드, 메서드, 추상 메서드
 *  - 타입으로 이용 가능
 *  - 추상메서드를 하나라도 가지고 있으면 추상 클래스가 되어야 한다
 *  - 상속 관계로 구성되어 다형성 적용이 가능 하다
 */
public abstract class Car {
	
	/*
	 * 추상 메서드(미완성 메서드)
	 *  - 미완성 메서드로 실행부({})이 구현 되지 않은 메서드이다.
	 * 	- 자식클래스에서 상속 받아서 구현 해야 한다
	 *  - 오버라이딩(재정의) 해주지 않으면 오류가 발생 한다
	 *  	>> 재정의
	 *  	>> 추상클래스
	 *  - 자식 클래스에 강제성을 부여 할 수 있는 방법 이다
	 *  
	 */
	public abstract void drive();
	
	@Override
	public String toString() {
		return "Car";
	}
}
