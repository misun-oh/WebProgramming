package com.chap1;

import com.chap1.generic.GenericBox;


public class GenericApp {
	public static void main(String[] args) {
		// 타입을 지정 하지 않으면 Object 타입이 된다
		GenericBox box = new GenericBox();
		
		// 다양한 방법으로 타입을 전달 할 수 있다
		GenericBox<String> box1 = new GenericBox<String>();
		GenericBox<String> box2 = new GenericBox();
		// 앞의 타입에 적어 줘야 하네요!!
		GenericBox box3 = new GenericBox<String>();
		
		// 강한타입체크 - 실행 타입에러가 나지않는다 
		//box1.setContent(1);
		
		
		box1.setContent("박스에 값을 입력");
		System.out.println(box1.getContent());
		// 형변환 없이 사용 할 수 있다
		String c = box1.getContent();
		System.out.println(c);
		
		box2.setContent("");
		
		// 타입 파라메터의 경우 클래스, 인터페이스만 사용가능
		// 기본타입은 올수 없다!
		GenericBox<Integer> box4 = new GenericBox<Integer>();
		int num = box4.getContent();
		
		
	}
}
