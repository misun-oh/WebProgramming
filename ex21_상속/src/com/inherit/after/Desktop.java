package com.inherit.after;

// 프로그램에서는 자식이 부모를 선택한다
public class Desktop extends Product{
	
	private boolean allInOne; // 일체 여부
	
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
	
	// 기본생성자
	public Desktop() {
		// 부모클래스가 지정 되어 있다면 부모가 먼저 생성이 된 후 자식이 생성
		super();
		System.out.println("Desktop(자식 기본 생성자) 호출");
	}
	// 매개변수 있는 생성자
	public Desktop(String brand, String pCode, String name, int price) {

		// 부모의 기본생성자를 호출
		// 부모의 생성자를 호출 하지 않으면 컴파일러에 의해 부모의 기본생성자가 실행
		//super(); 
		// 부모의 생성자를 호출해서 필드를 세팅
		super(brand, pCode, name, price);
		System.out.println("Desktop(자식 매개변수 있는 생성자) 호출");
		this.allInOne = false;
		// 필드에 접근할때 중요한 요소는 접근제한자 이다!!
		//super.brand="";
		//this.brand="";
	}
	
	public Desktop(String brand, String pCode, String name, int price, boolean allInOne) {

		// 부모의 기본생성자를 호출
		// 부모의 생성자를 호출 하지 않으면 컴파일러에 의해 부모의 기본생성자가 실행
		//super(); 
		// 부모의 생성자를 호출해서 필드를 세팅
		super(brand, pCode, name, price);
		System.out.println("Desktop(자식 매개변수 있는 생성자) 호출");
		this.allInOne = allInOne;
		// 필드에 접근할때 중요한 요소는 접근제한자 이다!!
		//super.brand="";
		//this.brand="";
	}
	
	public boolean isAllInOne() {
		return allInOne;
	}
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	
	@Override
	public String information() {
		// TODO Auto-generated method stub
		return super.information() + ","+ this.allInOne;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
