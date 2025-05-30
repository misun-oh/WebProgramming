package com.scan.practice;

import java.util.Scanner;

public class ScanEx {
	/**
	 * 사용자로부터 이름 ,키 , 몸무계를 입력 받아서 화면에 출력 합니다.
	 */
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 : ");
		String name = scan.next();
		System.out.println("이름 : " + name);

	}
}
