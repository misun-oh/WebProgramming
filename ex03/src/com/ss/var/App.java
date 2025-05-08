package com.ss.var;

import com.ss.var.practice.Calc;

// 클래스 선언부
public class App {

	// 실행 메서드의 선언부
	public static void main(String[] args) {
		// calc 클래스를 생성
		Calc c = new Calc();
		// add 메서드를 호출
		int res = c.add(1, 2);
		System.out.println(res);
	}

}
