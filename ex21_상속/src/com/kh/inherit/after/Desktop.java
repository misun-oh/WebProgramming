package com.kh.inherit.after;

// 프로그램에서는 자식이 부모를 선택한다
public class Desktop extends Product{
	public Desktop() {
	}

	/*
	 * 부모 필드를 초기화 할 수 있는 방법
	 * 1. super.를 통해서 부모의 필드에 직접 접근
	 * 		- 부모의 필드가 private이면 접근 불가
	 * 		- 부모의 필드가 default이면 같은 패키지 내에서만 접근이 가능
	 * 		- 부모의 필드가 public이면 어디서든지 접근이 가능 하다
	 * 
	 * 2. 부모의 setter메서드를 이용해서 초기화
	 * 		- 부모 클래스에서 setter메서드를 제공해 줄 경우 
	 * 		- setter메서더의 접근제한자가 public인 경우
	 * 
	 * 3. 부모의 생성자 호출
	 * 		- super([매개값, ...])을 통해서 자식의 생성자에서 부모의 생성자를 호출
	 */
	public Desktop(String brand, String pCode, String name, int price) {
		// 부모의 생성자를 호출해서 필드를 세팅
		super(brand, pCode, name, price);
	}
	
	
}
