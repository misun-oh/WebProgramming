package com.object.practice;

public class Book {
	private String title;			// 도서명
	private int price;				// 가격
	private double discountRate;	// 할인율
	private String author;			// 저자명
	
	// 기본 생성자
	public Book() {
	}
	
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
		return title + ", "+price+", "+discountRate+", "+author;
	}
}
