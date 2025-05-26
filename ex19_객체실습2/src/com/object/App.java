package com.object;

import com.object.practice.Book;

public class App {
	public static void main(String[] args) {
		Book book = new Book();
		Book book1 = new Book("이것이자바다", 32000, 0.2, "신용권");
		
		// 필드의 값을 세팅하지 않은 경우, 필드의 타입의 기본값으로 설정된다!!!!!
		System.out.println(book.info());
		System.out.println(book1.info());
		
		
	}
}
