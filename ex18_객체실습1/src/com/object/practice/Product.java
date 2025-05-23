package com.object.practice;

public class Product {

	/*
	 * 1. 필드 (전역 변수, 멤버 변수, 인스턴스 변수)
	 * 	- 클래스 영역에 바로 선언 하는 변수
	 * 	- 클래스의 어디서든지 사용이 가능 
	 * 
	 * 2. 필드의 생성과 소멸
	 * 	- 생성 시점 : new 연산자를 만나서 메모리에 올라가면 사용이 가능 
	 * 	- 소멸 시점 : 객체 소멸시
	 * 
	 * 3. 지역변수
	 * 	- 클래스 영역 안의 특정한 구역({})에 선언하는 변수
	 * 	- 선언된 코드블럭 안에서만 사용 할수 있다
	 */
	
	/*
	 * 접근 제한자
	 * 	클래스 앞, 메서드 앞, 필드 앞, 생성자 앞 
	 * 
	 * 1. public
	 * 		: 모든 패키지에서 제한 없이 사용이 가능
	 * 2. default
	 * 		: 같은 패키지 안에서만 사용 가능
	 * 		: 접근제한자를 선언하지 않으면 기본값으로 사용 된다
	 * 3. protected
	 * 		: 같은 패키지에 속하거나 상속관계인 경우 사용이 가능
	 * 4. private
	 * 		: 외부에서 접근 불가
	 */
	private String id;
	private String name;
	private String site;
	private int price;
	private double tax;

	// 기본생성자
	public Product() {
	}

	// 생성자 - 필드 초기화
	// 필드보다 지역변수의 우선순위가 더 높다!!!!
	public Product(String id, String name, String site, int price, double tax) {
		// this : 필드에 접근하기 위해서 사용
		this.id = id;
		this.name = name;
		this.site = site;
		this.price = price;
		this.tax = tax;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	
	
}
