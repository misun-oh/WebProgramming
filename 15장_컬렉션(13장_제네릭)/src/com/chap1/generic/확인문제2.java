package com.chap1.generic;
// p589
public class 확인문제2 {
	public static void main(String[] args) {
		// 제네릭 클래스 만들기
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		System.out.println(str);
		
		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
		System.out.println(value);
		
	}
}
