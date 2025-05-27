package com.object.practice;

public class StaticSample {
	private static String value;

	public static void toUpper() {
		// 모두 대문자 변경
		value = value.toUpperCase();
		// 모두 소문자 변경
//		value.toLowerCase();
	}
	
	public static void setChar(int index, char c) {
		
	}
	
	public static int valueLength() {
		return value.length();
	}
	
	public static String valueConcat(String str) {
		return value.concat(str);
	}
	
	public static String getValue() {
		return value;
	}

	// 정적메서드에서 인스턴스 필드를 사용할 수 없다!!!
	// this 키워드를 사용 할 수 없다!!
	public static void setValue(String value) {
		StaticSample.value = value;
	}
	
}
