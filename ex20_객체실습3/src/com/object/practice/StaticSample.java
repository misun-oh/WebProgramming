package com.object.practice;

import java.util.Arrays;

public class StaticSample {
	private static String value;

	public static void toUpper() {
		// 모두 대문자 변경
		value = value.toUpperCase();
		// 모두 소문자 변경
//		value.toLowerCase();
	}
	
	// 전달받은 인덱스 위치의 value 값을 전달받은 문자로 변경하는 static 메소드
	public static void setChar(int index, char c) {
		// 문자열을 => char[]로 반환
		char[] cc = value.toCharArray();
		System.out.println(Arrays.toString(cc));
		cc[index] = c;
		System.out.println(Arrays.toString(cc));
		value = String.valueOf(cc);
		// char[] => 문자열
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
