package com.chap1.generic;

public class WrapperClass {
	public static void main(String[] args) {
		// p526
		// 포장객체(WrapperClass)
		// 기본타입의 값을 참조타입으로 사용 하고 싶은경우
		int i = 10; // 기본타입
		
		// 자동형변환
		Integer num = i;	// 박싱 : 포장클래스(객체타입)에 기본값이 대입 될때 기본타입 -> 참조타입
		int ii = num; 		// 언박싱 : 기본타입에 포장클래스가 대입될때 참조타입 -> 기본타입
		
		System.out.println(num + ii);
		System.out.println(num.intValue());
		
		// 숫자 -> 문자
		// 문자 -> 숫자
		Integer.parseInt("10");
		Double.parseDouble("10.10");
		String.valueOf(10);
		
		String str = "";
	}
}
