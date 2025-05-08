package com.ss.variable.practice1;

public class VariablePractice {

	// 전역변수(필드) - 클래스 내부에서 어디서나 사용
	
	// 생성자 - 클래스명과 동일한이름, 반환타입이 없다

	// 기본생성자 - 매개변수가 없는 생성자
	// 프로그래머가 작성하지 않을경우, 컴파일러에 의해 기본생성자가 생성되어 진다
	public VariablePractice() {
		// new 키워드를 만나서 메모리에 올라갈때 실행 되어 진다
		System.out.println("VariablePractice 생성자");
	}
	
	// 메서드

	// 자바는 타입을 중요하게 생각하는 언어 - 메모리
	// 타입을 중요하게 생각하지 않는 언어 - 파이썬, JavaScritp
	
	// 접근제한자 반환타입 메서드명(매개변수의타입 매개변수의이름){
	// 		메서드의 내부에 매서드를 만들수 없다!!!!!!
	// }
	
	private void ex01() {
		// 지역변수 - 메서드 내부에서 생성된 변수
		// 메서드 내부에서만 사용가능
		// 문장의 끝은 세미콜론(;)
		System.out.println("ex01 메서드");
		
		/*
		 * 변수 선언
		 * 	타입 변수명;
		 * 자료형 변수명;
		 * 
		 * 타입/자료형 : 어떤 값을 저장할지, 어떤 크기의 메모리를 할당 받을것인지에 대한 정보
		 * 변수명 : 변수의 이름으로 변수값을 읽고 쓰고 지우는 작업을 할수 있다!
		 * 
		*/
		
		// 변수 선언
		int num;
		// 초기화 되지 않은 변수를 사용할수 없다!
		//System.out.println(num);
		// 변수 초기화
		num = 5;
		
		System.out.println("num : " + num);
		// 변수의 선언과 초기화
		int num1 = 6;
		System.out.println("num1 : " + num1);
		
		// 변수를 선언하고 사용하지 않은경우, 노란 경고가 출력됩니다
		boolean flag;
		// 제어문에서 많이 사용됩니다.
		flag = false;
		
		
		/*
		 * 자료형
		 * */
		
		// 기본타입
		// 논리형 - true, false 두가지 값만 저장 가능
		boolean isTrue = false; // 논리값(참, 거짓)
		// 변수의 값을 변경
		// 오른쪽에 값을 왼쪽 변수에 대입 
		// = 대입연산자
		isTrue = true;
		
		// + 연산자는 문자열의 연결에도 사용되어 진다
		System.out.println("isTrue" + isTrue);
		// 정수형
		int num2 = 50; // 약 -20억 - 20억 까지의 정수를 표현
		System.out.println("num2 : " + num2);
		// int 타입보다 더큰값을 저장 하려고 하면 오류가 발생
		// 범위를 int < long
		// l, L 을 붙여 주어야 합니다.
		// 리터럴 : 값 그체 = 기본적으로 정수가 입력 되면 int
		long lnum = 11111111111L;
		System.out.println("lnum : " + lnum);
		// 실수형
		// 숫자 뒤에 f라고 타입을 지정 해야 합니다. 
		// float < double
		// 실수의 경우 기본적으로 리터럴의 타입을 double 타입으로 인식
		// 더큰값이 저장 될수 없다!
		float fNum = 3.13F;
		System.out.println("fNum : " + fNum );
		double dNum = 3.14; // 8byte 실수를 저장 할수 있는 공간. 부동소수점방식으로 수를 저장
		// 문자형
		char ch = 'a';
		
		// 참조타입
		// 문자열
		String name = "hello"; 
		
		
		// 형변환
		byte bnum1 = 123;
		// 자동형변환
		// 범위가 큰 타입으로 자동 형 변환 되어 질수 있다
		int inum = bnum1;
		// 연산시점에서 정수는 int 타입으로 형 변환 되어 연산되어 연산결과가 int가 된다
		//bnum1 = bnum1+bnum1;
		
		
		
		String str = 1+1+"";
		str = String.valueOf(1+1);
		str = ""+1+1+"";
		System.out.println(">>>>>>>>>" + str);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
    public static void main(String[] args) {
        byte b = 127; // byte의 최대값
        System.out.println("초기값: " + b);

        b++; // 127 + 1 -> 오버플로우 발생
        System.out.println("b++ 후: " + b); // -128 출력

        b--; // -128 - 1 -> 다시 오버플로우 발생
        System.out.println("b-- 후: " + b); // 127 출력

        // 강제로 byte 범위를 넘는 연산
        byte overflow = (byte)(b + 10); 
        System.out.println("b + 10 (byte 캐스팅): " + overflow);
    }
	
	
}
