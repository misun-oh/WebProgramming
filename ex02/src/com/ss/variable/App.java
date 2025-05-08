package com.ss.variable;


// 다른 패키지에 있는 클래스를 사용하는경우 import문을 이용하여 패키지를 명시
import com.ss.variable.practice1.VariablePractice;

// 클래스의 파일명과 클래스의 이름이 일치하지 않으면 오류
// 첫글자는 대문자
public class App {
		
	// 실행을 담당하는 메서드
	// void : 반환타입이 없음을 의미하는 예약어
	public static void main(String[] args) {
		// 변수 선언
		// 변수의타입 변수이름
		VariablePractice vp = new VariablePractice();
		// 변수에 접근하기 위해서 변수 이름을 사용한다
		vp.ex01();
		
		
		
		
	}
}
