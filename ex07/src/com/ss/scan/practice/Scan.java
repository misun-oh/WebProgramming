package com.ss.scan.practice;

import java.util.Scanner;

public class Scan {

	/**
	 * 사용자의 입력을 m단위로 입력 받아 옵니다.
	 * nextDouble()
	 */
	public void bmi_m() {
		// 스캐너를 이용해서 키와 몸무게를 입력 받아서 화면에 출력
		Scanner scanner = new Scanner(System.in);
		// 키
		System.out.println("키 : ");
		double height = scanner.nextDouble();
		// 몸무게
		System.out.println("몸무게 : ");
		double weight = scanner.nextDouble();

		// Bmi를 구한후(연산) 변수에 값을 저장
		// 변수명은 bmi로 한다
		// 🍀bmi를 구할때 키는 m단위로 입력 해야 합니다
		double bmi = weight/(height*height);
		System.out.printf("당신의 키는 %.2fm, 몸무계는 %.2fkg 이고, \n", height, weight);
		System.out.printf("당신의 bmi는 %.2f 입니다.",bmi);
		
		/*
		 * bmi값에 따라 분류 하세요
		 * <18.5 저체중
		 * <23	 정상
		 * <25   과체중
		 * 나머지  비만
		 * */
		
		/*
		 * if(조건){
		 * } else if(조건){
		 * } else {
		 * }
		 * */
		String type = "";
		// && 그리고, || 또는
		if(bmi<18.5) {
			type="저체중";
			// 조건이 참일때 코드블럭이 실행
			//System.out.println("당신은 저체중 입니다.");
		} else if(bmi<23) {
			type="정상";
			//System.out.println("당신은 정상 입니다.");
		} else if(bmi<25) {
			type="과체중";
			//System.out.println("당신은 과체중 입니다.");
		} else {
			type="비만";
			//System.out.println("당신은 비만 입니다.");
		}
		
		System.out.printf("당신은 %s 입니다.",type);
		
	}
	
	/**
	 * 사용자의 입력을 cm단위로 입력 받아 옵니다.
	 * nextInt()
	 */
	public void bmi() {
		// 웹어플리케이션서버(WAS) : 동적 서비스
		// 웹서버로부터 수집된 정보를 받아 옵니다.
		Scanner scanner = new Scanner(System.in);
		// 변수이름에 쩜 찍으면 사용한 가능한 메서드와 필드 정보를 알수 있다!
		
		System.out.print("키(cm) : ");
		// 정수타입이 아닌 문자나 실수가 입력될 경우 
		// 타입불일치로 예외가 발생 할 수 있다
		int height = scanner.nextInt();
		System.out.println("키는 " + height + "입니다.");
		System.out.print("몸무계(kg) : ");
		int weight = scanner.nextInt();
		System.out.println("몸무계는 " + weight + "입니다.");
		
		// 선언하지 않고 사용 할 수 없다!
		// sum = 1+1;
		
	}
	
	
	
//	public void bmi() {
//		// TODO Auto-generated method stub
//		
//	}
	
	// 반환타입이 없다
	// 클래스명과 동일한 이름
	// 기본생성자 : 매개변수가 없는 생성자
//	public Scan() {
//		// TODO Auto-generated constructor stub
//	}
}
