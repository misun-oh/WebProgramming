package com.control;

import java.util.Scanner;

public class WhileEx {
	/*
	 * while 문
	 *   
	 *   while(조건식) {
	 *      .. 반복적으로 실행될 코드 ..
	 *   
	 *   	[증감식, 분기문]
	 *   }
	 *   
	 * - 조건식이 true일 경우 해당 실행 코드를 실행한다.
	 * - 조건식이 false일 경우 해당 반복문을 종료한다.
	 * 
	 * 반복문의 종료
	 * 	1. 조건식이 false
	 * 	2. break문을 만났을 경우
	 */
	public static void main(String[] args) {
		// 사용자에게 ID를 입력 받고 출력 하세요(횟수)
		// id : 
		Scanner scanner = new Scanner(System.in);
//		int index = 1;
//		while(true) {
//			System.out.println("id : ");
//			String id = scanner.next();
//			System.out.println("당신의 아이디는 " + id + "입니다.(" + index + ")");
//			System.out.printf("당신의 아이디는 %s입니다(%d)\n", id, index);
//			index++;
//		}

		/*
		 * for 문
		 * 
		 * [표현법]
		 *   for(초기식; 조건식; 증감식) {
		 *       .. 반복적으로 실행시키고자하는 실행구문 ..
		 *   }
		 *   
		 * - 초기식 : 반복문이 수행될 때 단 한 번만 실행되는 구문으로 반복문 안에서 사용될 변수를 선언하고 초기값을 대입한다.
		 * - 조건식 : 반복문이 수행될 때 조건을 작성하는 구문으로 조건식이 참(true)이면 실행 구문을 실행하고, 조건식이 거짓(false)이
		 *          되는 순간 반복을 멈추고 빠져나온다.
		 * - 증감식 : 반복문을 제어하는 변수 값을 증감 시키는 부분으로 주로 초기식에 제시한 변수를 가지고 증감 연산자(++, --)를 사용한다.
		 * * 초기식, 조건식, 증감식은 생략이 가능하고 모두 생략하면 무한 루프에 빠진다. (생략 시에도 ;은 반드시 필요하다.(for(;;)))
		 */
		for(int i=0;i<10;i++) {
			System.out.println("id : ");
			String id = scanner.next();
			System.out.println("아이디 : " + id + "("+i+")");
		}
		
		
		
	}
	
	private void whileEx() {
		int i=1;
		while(i<=10) {
			// 조건에 사용되는 값이 변하지 않는경우 코드블럭이 무한 반복
			System.out.println(i + " ");
			i++;
		}

	}
	
	private void randomPrint() {
		// 1부터 랜덤값(1 ~ 10)까지의 합계
		// 0.0 ~ 1.0 사이의 실수값을 반환
		// 0.0000000..1 ~ 0.9999999999   * 10
		// 0.00...1 ~ 9.9999             + 1
		int num = 1;
		// 범위 
		while(num<=10) {
			// 무한반복
			System.out.println(Math.random() * 10 + 1);
			num++;
		}
		
	}
}
