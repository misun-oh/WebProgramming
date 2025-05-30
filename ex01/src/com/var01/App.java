package com.var01;

import com.var01.practice.VarEx;

public class App {
	// 전역변수(필드) 선언
	// 필드, 메서드의 접근제한자는 생략이 가능
	public static String procName = "실습문제";
	
	public static void main(String[] args) {
		// 1. 일반 필드, 메서드를 사용하기 위해서는 생성해서 사용
		App app = new App();
		System.out.println(app.procName);
		
		// 2. static 붙은 필드만 사용가능하다
		System.out.println(procName);
		
		VarEx ve = new VarEx();
		//ve.method1();
		//ve.method2();
		ve.method3();
		
	}
}
