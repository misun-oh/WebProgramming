package com.var.practice;

import java.util.Scanner;

public class VarEx {
	// 사용자의 입력을 받기 위해 스캐너 객체를 생성
	Scanner scanner = new Scanner(System.in);
	
	public void method1() {
		/*
		 * 스캐너를 이용하여 사용자의 입력을 받아 변수에 저장하고 출력 
		 *	입력받을 값 : 이름(문자열), 성별(char), 나이(정수), 키(실수)
		 * */
		System.out.print("이름 : ");
		String name = scanner.next();
		// scanner.next() : 문자열이 반환
		System.out.print("성별 : ");
		char gender = scanner.next().charAt(0);
		System.out.print("나이 : ");
		int age = scanner.nextInt();
		System.out.print("키 : ");
		double height = scanner.nextDouble();
		
		System.out.println("이름 : " + name);
		System.out.printf("당신의 이름은 %s이고 성별은 %s 나이는 %d 키는 %.2f 입니다."
								, name, gender, age, height);
		
	}

	public void method2() {
		/*
		 * 	키보드로 정수 두개를 입력 받아 두수의 사칙연산(+,-,*,/) 결과를 출력
		 */
		System.out.println("정수1 입력 :");
		int num1 = scanner.nextInt();
		System.out.println("정수2 입력 :");
		int num2 = scanner.nextInt();
		
		System.out.println(num1 + "+" + num2 + "=" + (num1+ num2));
		System.out.printf("%d + %d = %d \n", num1, num2, num1+num2);
		System.out.printf("%d - %d = %d \n", num1, num2, num1-num2);
		System.out.printf("%d * %d = %d\n", num1, num2, num1*num2);
		System.out.printf("%d / %d = %d\n", num1, num2, num1/num2);
		System.out.printf("%d %% %d = %d\n", num1, num2, num1%num2);
	
		System.out.println(" \" ");
		
		
	}

	public void method3() {
		/*
		 * 키보드로 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 출력
		 * 면적=가로*세로, 둘레=(가로+세로)*2
		 * */
		System.out.print("가로 : ");
		double num1 = scanner.nextDouble();

		System.out.print("세로 : ");
		double num2 = scanner.nextDouble();
		
		System.out.println("면적 : " + (num1 * num2));
		double num3 = (num1 + num2) * 2;
		System.out.println("둘레 : " + num3 );
		
	}
	

}
