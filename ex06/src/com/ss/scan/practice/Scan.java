package com.ss.scan.practice;

import java.util.Scanner;

public class Scan {
	/**
	 * 사용자의 키와 몸무게를 입력 받아서 출력 합니다.
	 */
	public void bmi() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("키를 입력해주세요(cm) : ");
		// 사용자의 입력값을 변수에 저장
		//double height = scanner.nextDouble();
		int height = scanner.nextInt();
		// m로 변환
		// 정수/정수 = 정수 ->.0
		// 정수/실수 = 실수
		double height_m = height/100.0;
		System.out.println("m변환 후 : " + height_m);
		
		System.out.print("몸무게를 입력해주세요(kg) : ");
		int weight = scanner.nextInt();
		
		// 값을 출력
		System.out.println("당신의 키는 " + height_m);
		System.out.println("당신의 몸무계는 " + weight);
		
		double bmi = weight/(height_m*height_m);
		System.out.println("당신의 BMI는 " + bmi + "입니다.");
		
		
		
	}
}
