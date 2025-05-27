package com.object.practice;

/*
 * 필드의 초기화
 * 1. JVM이 정한 기본값으로 초기화
 * 		- 타입의 기본값으로 초기화
 * 
 * 2. 명시적 초기화
 * 3. 생성자를 이용한 초기화
 * 4. 인스턴스 블록을 이용한 초기화
 * 
 */
public class Book {
	private String title;			// 도서명
	private int price;				// 가격
	// 명시적 초기화
	private double discountRate=0.1;	// 할인율
	private String author;			// 저자명
	
	public static int pages;
	
	// 인스턴스 블록을 이용한 초기화
	// InitBlock
	// 인스턴스 블록은 필드를 초기화 시키는 블럭으로 객체 생성시마다 실행되고 초기화 한다.
	{
		author = "김형경";
		pages = 100;
	}
	
	// 클래스 변수를 초기화 시키는 블럭으로 프로그램 시작시 한번만 실행!!!!
	static {
		pages = 210;
		//author = "";
	}
	// 기본 생성자
	public Book() {
	}
	
	// 생성자의 역할 - 필드를 초기화
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	// 매개변수 있는 생성자
	public Book(String title, int price, double discountRate, String author) {
		// 생성자 
		this(title, author);
		this.price = price;
		this.discountRate = discountRate;
	}
	
	public String info() {
		int age;
		//age+=1;
		//age++;
		return title + ", "+price+", "+discountRate+", "+author+", "+pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		// 메서드에서 필드에 접근해서 계산하여 반환
		return (int)(price-(price*discountRate));
	}

	public void setPrice(int price) {
		if(price>0) {
			this.price = price;
		} else {
			//System.out.println("금액은 0보다 큰수를 입력 해야 합니다.");
			System.err.println("금액은 0보다 큰수를 입력 해야 합니다.");
		}
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
