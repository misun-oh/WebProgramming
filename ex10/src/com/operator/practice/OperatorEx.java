package com.operator.practice;

// ctrl + shift + o : 필요없는 임포트 제거
import java.util.Scanner;

public class OperatorEx {
	
	// 반환타입이 없고 클래스명과 동일한 이름
	public OperatorEx() {
		// TODO Auto-generated constructor stub
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public void method1() {
		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다", 양수가 아니면 "양수가 아니다"를 출력
		// 값을 재사용 하기 위해서 변수에 저장 해준다
		System.out.print("정수를 입력 : ");
		int num = scanner.nextInt();
		
		// if(조건){}
		if(num > 0) {
			// 조건이 참이면 코드블럭을 실행
			System.out.println("양수");
		} else {
			// 조건이 거짓이면 코드블럭을 실행
			System.out.println("양수가 아님");
		}
		
		// 삼항연산자
		// 타입 변수명 = (조건) ? 참일때 반환값 : 거짓일때 반환값;
		String res = num > 0 ? "양수" : "양수가 아님"; 
		boolean result = num > 0 ? true : false;
		
		System.out.println(res);
		
		if(result) {
			System.out.println("양수");
		} else {
			System.out.println("양수가 아님");
		}

	}
	
	public void method2() {
		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다", 			조건1
		// 양수가 아닌 경우 중  0이면 "0이다"							조건2
		// 아니면 , 0이아니면 "음수다"를 출력
		/*
		if(조건1) {
		} else if(조건2) {
		} else {
		}
		*/
		System.out.print("정수 입력 : ");
		// 사용자가 값을 입력하고 엔터를 입력하면 사용자가 입력한 값을 반환
		// 지역변수 - 코드블럭에서만 사용 가능한 변수
		int num = scanner.nextInt();
		
		if(num > 0) {
			System.out.println("양수");
		// = : 대입 연산자
		// == : 비교 연산자
		} else if(num == 0) {
			System.out.println("0을 입력 하셨네요");
		} else {
			System.out.println("음수");
		}
		
		String res = num > 0 ? "양수" : (num == 0 ? "0" : "음수");
		System.out.println(res);
		
	}
	
	public void method3() {
		// 키보드로 입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "홀수다"를 출력
		System.out.println("정수 입력 : ");
		int num = scanner.nextInt();
		
		// 짝수/홀수 판단 = 나머지 연산자를 이용
		// 2로 나눈 나머지가 0이면 짝수, 1이면 홀수
		int res = num % 2;
		
		if(res == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		// == 비교 연산자 : 오른쪽에있는 값과 왼쪽에 있는 값이 같은지 판단
		// 같은면 true, 다르면 false
		String resStr = (res == 0) ? "짝수" : "홀수";
		System.out.println(resStr);
		
	}
	
	public void method4() {
		// 모든 사람이 사탕을 골고루 나눠 가지려고 한다. 
		// 인원수와 사탕개수를 키보드로 입력 받고
		// 1인당 동일하게 나눠 가진 사탕개수와 나눠주고 남은 사탕의 개수를 출력
		System.out.println("인원수 : ");
		int people = scanner.nextInt();
		System.out.println("사탕수 : ");
		int candy = scanner.nextInt();
		
		System.out.println("1인당 사탕의 갯수 : " + (candy/people));
		System.out.println("남은 사탕의 수 : " + (candy%people));
		
	}
	
	public void method5() {
		// 나이를 키보드로 입력 받아 어린이(13세이하)인지, 청소년(13세초과~ 19세이하)인지,
		// 성인(19세초과)인지 출력
		System.out.println("나이 : ");
		int age = scanner.nextInt();
		
		if (age<=13) {
			System.out.println("어린이");
		} else if(age<=19) {
			System.out.println("청소년");
		} else {
			System.out.println("성인");
		}
		
		String res = age<=13?"어린이":(age<=19)?"청소년":"성인";
		System.out.println(res);
		
	}
	
	public void method6() {
		// 3개의 수를 키보드로 입력 받아 입력 받은 수가 모두같으면 true, 아니면 false를 출력하세요.
		System.out.println("정수1 : ");
		int num1 = scanner.nextInt();
		
		System.out.println("정수2 : ");
		int num2 = scanner.nextInt();
		
		System.out.println("정수3 : ");
		int num3 = scanner.nextInt();
		
		// && : 그리고, || : 또는
		if(num1 == num2 && num2 == num3) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		boolean res = num1 == num2 && num2 == num3;
		System.out.println(res);
	}
}







