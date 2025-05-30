package com.chap1.generic;

/*
 * <T> : 타입 파라메터를 의미 
 * 			T이외의 다른 알파벳으로 대체 가능
 * 
 * 타입파라메터 : 외부로 부터 전달 받은 타입
 */
public class GenericBox <T>{
	// 필드의 타입
	private T content;

	// 반환 타입
	public T getContent() {
		return content;
	}

	// 매개변수의 타입
	public void setContent(T content) {
		this.content = content;
	}
	
}
