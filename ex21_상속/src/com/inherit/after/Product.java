package com.inherit.after;

// 부모클래스
// 세개의 클래스에 공통으로 들어있는 요소를 추출하여 부모클래스를 만들어 봅시다
public class Product {
	
	// protected(#) 접근제한자
	protected String brand; // 브랜드
	private String pCode; // 상품코드
	private String name; // 상품명
	private int price; // 가격
	
	public Product() {
		System.out.println("Product(부모 클래스) 기본 생성자");
	}
	
	public Product(String brand, String pCode, String name, int price) {
		// 기본생성자를 호출
		// 메서드의 코드블럭 첫줄에 위치 해야 한다
		super();
		System.out.println("Product(부모 클래스) 매개변수 있는 생성자");

		this.brand = brand;
		this.pCode = pCode;
		this.name = name;
		this.price = price;
	}

	/*
	 * 필드의 정보를 하나의 문자열로 반환
	 */
	public String information() { 
		return "brand : " + this.brand + ", " + this.name + ", " + this.pCode + ", " + this.price;
		//return null;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
