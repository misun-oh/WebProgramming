package com.ss.var;

// 패키지가 다른 소스를 사용하기 위해서 위치를 알려줘야합니다!
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
	public App() {
		// TODO Auto-generated constructor stub
	}

	private void ex() {
		// TODO Auto-generated method stub

	}
	public int ex01(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1+num2;
	}
}
