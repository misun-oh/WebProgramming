package com.control;

import java.util.Scanner;

/*
 * switch 문
 * 
 * [표현법]
 *   switch(조건식) {
 *     case 값1 :
 *          .. 실행 코드 1..;
 *          break;
 *     case 값2 :
 *          .. 실행 코드 2..;
 *          break;
 *     case 값3 :
 *          .. 실행 코드 2..;          
 *          break;
 *     [default] :
 *          위 조건을 모두 만족하지 않을 경우 실행하게 될 코드
 *   }
 * 
 * - switch 문은 if문과 마찬가지로 조건문이다.
 * - switch 문은 if문처럼 조건식이 true일 경우에 실행문을 실행하는 것이 아니라, 
 *   조건식의 결과 값(정수, 문자, 문자열)에 따라 실행문이 선택된다.
 * - if문과 다르게 실행 코드를 실행하고 자동으로 빠져나가지 못한다. (break가 필요하다.)
 */
public class SwitchEx {
	
	public static void main(String[] args) {
		/*
		 * 사용자로부터 과일 이름을 입력받는다.
		 * 입력된 과일의 값을 지정해서 출력한다.
		 * 지정한 과일이 없으면 "안 팔아요~" 출력
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("과일 이름 : ");
		String fruit = scanner.next();
		
		switch (fruit) {
			case "복숭아" :
				System.out.println("복숭아는 1000원 입니다.");
				break;
			case "사과" :
				System.out.println("사과는 2000원 입니다.");
				break;
			default :
				System.out.println("안팔아요~");
			
		}
		
		
		
	}
	
	

}







