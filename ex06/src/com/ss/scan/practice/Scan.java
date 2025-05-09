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
		
		// () : 조건문(비교문장) -> true, false
		if(bmi<23) {
			System.out.println("정상체중 입니다.");
		// 조건이 여러개인 경우
		} else if(bmi>23 && bmi<=25) {
			System.out.println("체중관리가 필요합니다.");		
		// 조건이 참이 아닌경우
		} else {
			System.out.println("bmi(" +bmi+ ")값을 확인 해주세요");
			System.out.println("관리자에게 문의 하세요");
		}
		
	}
}
