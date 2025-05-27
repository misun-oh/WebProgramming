package com.object.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NonStaticSample {
	
	/*
	 * HashSet
	 * Set 인터페이스의 구현체
	 * 중복 없는 요소를 저장, 순서를 보장하지 않는다
	 */
	public void printLottoNumbers() {
		// 중복을 허용 하지 않음
		Set<Integer> lotto = new HashSet<Integer>();

		while(lotto.size() < 6) {
			int num = (int)(Math.random()*45)+1;
			lotto.add(num);
		}
		System.out.println(lotto);
				
	}

	public void outputChar(int num, char c) {
		for(int i=0;i<num;i++) {
			System.out.print(c+" ");
		}
		System.out.println();
	}
	
	/*
	 * 반환타입이 있는 메서드 : 직접 객체를 수정 하지 않는다
	 * 반환타입이 없는 메서는 : 객체를 직접 수정 하는 경우가 많다!
	 * 
	 * 문자열과 시작 인덱스, 끝 인덱스를 전달 받아 해당 인덱스 범위의 문자열을 리턴
	 */
	public String mySubstring(String str, int index, int index2) {
		
//		String s = "사과,배,포도";
//		// 문자열을 입력 받아서 구분자로 끊어서 배열을 반환 하는 메서드
//		String ss[] = s.split(",");
//		// 문자열을 수정 하여 반환 한다
//		s = s.replace("사과", "미니사과");
//		System.out.println("s: " + s);
//		// 시작인덱스는 포함하고 끝 인덱스는 포함하지 않는다
//		System.out.println("s.substring(3) : " + s.substring(3));
//		System.out.println("s.substring(7,9) : " + s.substring(7,9));
//		
//		System.out.println("s : " + s);
//		System.out.println(Arrays.toString(ss));
		
		return str.substring(index,index2);
	}
}
