package com.inherit.after;

public class SmartPhone extends Product{

	private String mobileAgency; // 통신사
	
	public SmartPhone(String brand, String pCode, String name, int price) {
		super(brand, pCode, name, price);
	}

	public String getMobileAgency() {
		return mobileAgency;
	}

	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}

	/*
	 * 메서드의 재정의(오버라이딩)
	 * 	- 자식 클래스가 상속받은 부모 클래스의 메서드를 재정의 하는것
	 * 	- 자식 객체에서는 재정의된 메서드가 우선 된다
	 * 
	 * 오버라이딩의 조건
	 * 	- 부모클래스의 메서드와 동일한 이름
	 * 	- 매개변수의 갯수, 타입(자료형), 순서가 동일 해야한다
	 *  - 반환형 동일
	 *  - 부모의 접근 제한자보다 넓은 범위여야 한다 p295
	 *  
	 * @Override 어노테이션
	 *   - 명시하지 않아도 오버라이딩 됩니다
	 *   - 어노테이션을 붙이는 이유
	 *   	. 해당 메서드가 오버라이딩된 메서드 라는것을 컴파일러에게 알려주는 역할
	 *   	. 자식 메서드가 오버라이딩이 아닌경우 컴파일 오류를 발생
	 */
	@Override
	public String information() {
		// TODO Auto-generated method stub
		return super.information();
	}
	
	/*
	 * Object 클래스의 toString() 메서드 오버라이딩
	 * 	- 객체의 정보를 문자열로 반환 (패키지명을 포함한 클래스명 @ 16진수hashcode)
	 *  - print 메서드의 경우 객체의 참조값을 넘겨주면 내부적으로 super.toString() 메서드를 호출 한다
	 *  - 만약 자식 클래스에서 재정의 한경우 자식객체의 재정의된 메서드가 호출이 된다  
	 */
	@Override
	public String toString() {
		
		return super.information() + ", " + mobileAgency;
	}
	
	/*
	 * 매개값으로 전달 받은 객체와 동일하면 true, 아니면 false를 반환 
	 */
	@Override
	public boolean equals(Object obj) {
		System.out.println("override");
		// 통신사, 상품명
		// 부모타입으로 자동 형변환(모든 클래스는 Object 로 자동 형변환이 가능 하다)
		// 자식타입으로는 명시적 형변환
		// 명시적 형변환 object -> smartphone
		SmartPhone sh = (SmartPhone)obj;
		// 통신사, 상품명
		if(sh.mobileAgency == mobileAgency
				&& sh.getName() == getName() ) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	
	public boolean equals(SmartPhone sh) {
		System.out.println("SmartPhone");

		// 통신사, 상품명
		if(sh.mobileAgency == mobileAgency
				&& sh.getName() == getName() ) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
