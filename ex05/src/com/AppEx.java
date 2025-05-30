package com;

public class AppEx {
	// 전역변수
	int num = 1;
	
	public static void main(String[] args) {
		// 지역변수
		
		// 타입 변수명 = 값(리터럴)
		int num = 1;
		// 동일한 변수명은 사용 할 수 없다
		//double num= 3.14;
		boolean isTrue = false;
		String str = "반갑습니다.";
		
		System.out.println(num+1);
		System.out.println(isTrue);
		// +연산자 : 문자의 연결
		System.out.println(str+1+1);
		
		int num1;
		
		// 변수를 초기화 하지 않은 변수는 사용 할수 없다
		// add(1, num1);
		// 메서드를 호출 : 매개변수의 갯수만큼 값을 넣어 줘야 한다
		// 1. 값을 직접 넣어주는 방식
		add(1, 2);
		// 2. 변수를 활용하는 방식
		add(num, num);
		
		// int, double, boolean, String
		int 변수명 = 0;// 타입에 맞는 값을
		
		
		
		// 변수 num1234를 선언하고 값(1234)를 대입해보세요
		int num1234 = 1234;
		// 문자열 "삼성캠퍼스"를 입력하고 변수 ss에 담아봅시다
		String ss = "삼성캠퍼스";
		
		// num1234와 ss를 연결해서 출력 해봅시다
		// 변수의 이름을 불러주면 저장된 값이 출력된다
		System.out.println(num1234 + ss);
		
		// 상수
		// 상수 이름은 대문자로 작성하는것이 관례이다
		final String STR_STR;
		final int INT_INT;
		STR_STR = "삼성캠퍼스";
		// 상수는 값을 한번만 초기화 할 수 있다
		// STR_STR = "삼성캠퍼스";
		
		
		
		
	}

	// 메서드의 선언부 : 메서드를 정의
	// 접근제한자 반환타입 메서드명()
	// static : 생성하지 않고 사용할수 있다
	private static void add(int a, int b) {
		// 매개변수에서 사용된 이름은 재사용할 수 없다
		// int a = 1; 
		int aa = 1;
	}

	
} 