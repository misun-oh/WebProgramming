package com.kh.inherit;

import com.kh.inherit.after.Desktop;

public class App {

	/*
	 * java 프로그램에서 유틸리티을 만들때 static이 사용된다고 하던데 유틸리티가 뭐야?
	 */
	public static void main(String[] args) {
		System.out.println("===========  new Desktop(); 기본 생성자 호출");
		Desktop dt = new Desktop();
		System.out.println(dt.information());

		System.out.println("===========  new Desktop(null, null, null, 0); 매개변수 있는 생성자 호출");
		Desktop dt1 = new Desktop("삼성", "s-25", "s25", 1500000);
		System.out.println(dt1.information());

		// 메인메서드가 모두 실행 되어지면 프로그램이 종료
	}

}
