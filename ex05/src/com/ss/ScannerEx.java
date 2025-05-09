package com.ss;

import java.util.Scanner;

public class ScannerEx {
	
	public static void main(String[] args) {
		
		// Scanner를 이용하여 입력을 받아 봅시다
		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 사용자로 부터 값을 입력 받아 옵니다
		// 콘솔창에서 사용자의 입력을 대기
		// 사용자 값을 입력하고 엔터키를 누르면 사용자의 입력 값을 반환 한다
		System.out.print("이름 : ");
		String str = scan.next();
		System.out.print("나이 : ");
		int age = scan.nextInt();
		System.out.print("키 : "); // 실수
		double height = scan.nextDouble();
		System.out.print("취미 : ");
		String hobby = scan.next();
		
		// 예외처리
		// 프로그램이 비정상적으로 종료 되지 않도록 하는 처리
		
		System.out.println("=================");
		System.out.println("사용자 정보");
		System.out.println("이름 : " + str);
		System.out.println("나이 : " + age );
		System.out.println("키 : " + height );
		System.out.println("취미 : " + hobby );

		
	}
	
}
