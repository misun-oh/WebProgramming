package com.ss.scan;

import com.ss.scan.practice.Scan;

public class App {

	public static void main(String[] args) {
		// Scan객체를 생성
		// 타입 변수명 = 값;
		// 참조타입인 경우 new라는 키워드를 만나 생성자가 호출되어진다
		// 기본생성자 : 
		Scan scan = new Scan(); 
		
		// bmi()메서드를 호출
		scan.bmi_m();
		
	}

}
