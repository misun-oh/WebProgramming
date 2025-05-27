package com.object;

import com.object.practice.Book;

public class App {
	public static void main(String[] args) {
		System.out.println(Book.pages);

		Book book = new Book();
		Book book1 = new Book("이것이자바다", 32000, 0.2, "신용권");
		Book book2 = new Book("노인과바다", 16000, 0.1, "헤밍웨이");
		
		System.out.println("=========================");
		// 필드의 값을 세팅하지 않은 경우, 필드의 타입의 기본값으로 설정된다!!!!!
		System.out.println(book.info());
		System.out.println(book1.info());
		System.out.println(book2.info());
		System.out.println("========================");

		// setter 메서드를 활용해서 필드를 초기화
		book.setTitle("꽃피는고래");
		book.setPrice(15000);
		book.setDiscountRate(0.5);
		book.setAuthor("김형경");
		System.out.println(book.info());
		System.out.println("=========================");
		
		System.out.println("도서명 : " + book.getTitle());
		System.out.println("할인된 가격 : "+ book.getPrice());
		System.out.println("도서명 : " + book1.getTitle());
		System.out.println("할인된 가격 : "+ book1.getPrice());
		System.out.println("도서명 : " + book2.getTitle());
		System.out.println("할인된 가격 : "+ book2.getPrice());
	}
}
