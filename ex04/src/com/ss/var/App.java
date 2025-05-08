package com.ss.var;

import com.ss.var.practice.Calc;

// 실행용 클래스
public class App {

	public static void main(String[] args) {
		// calc 생성
		Calc calc = new Calc();
		
		// 메서드 호출후 결과를 변수에 대입
		int res = calc.minus(2, 1);
		// 출력 - 재사용
		System.out.println(res);
	}

}
