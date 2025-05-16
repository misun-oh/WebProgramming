package com.loop.practice;

import java.util.Scanner;

public class LoopEx {

	/**
	 * 로또
	 * 무작위를 이용하여 1 ~ 46까지의 수중 랜던한 수 5개를 출력 해주세요
	 */
	public void method0() {
		// 무작위수(랜덤) - 로또
		// 1 ~ 46 까지의 수 중에서 랜덤으로 5개의 수를 뽑아봅시다
		// 같은 타입의 값을 여러개 저장 하기 위해서 배열을 이용합니다.
		int num1 = (int) (Math.random() * 10) + 1;
		int num2 = (int) (Math.random() * 10) + 1;
		int num3 = (int) (Math.random() * 10) + 1;
		int num4 = (int) (Math.random() * 10) + 1;
		int num5 = (int) (Math.random() * 10) + 1;

		System.out.printf("%d %d %d %d %d", num1, num2, num3, num4, num5);

	}
	
	/**
	 * 구구단
	 * 2단 ~ 9단 까지 출력 하세요
	 */
	public void method00() {
		// 2단 ~ 9단 
		for(int dan=2;dan<10;dan++) {
			// 2단 출력
			// 변수 i는 반복문이 실행 되면서 1부터 9까지 증가합니다
			// i = 1 ~ 9
			System.out.println(dan+"단");
			for(int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			}
			
		}
	}

	/**
	 * 정수를 입력 받고 정수에 해당하는 단을 출력 하시오
	 * 구구단
	 */
	public void method01() {
		while(true) {
			int dan = scanner.nextInt();
			// i : 1 ~ 9
			for(int i=1; i<10; i++) {
				System.out.println(dan+"단");
				System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			}
		}
	}
	
	
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * 사용자로 부터 한 개의 값을 입력 받아 
	 * 1부터 그 숫자 까지의 숫자들을 모두 출력 하세요. 
	 * 단, 입력한 수는 1보다 크거나 같아야 합니다.
	 * 만일 1 미만의 숫자가 입력 됐다면 "잘못입력하셨습니다."를 출력하세요. 
	 * 
	 * (for문이용) ex. 1이상의숫자를입력하세요: 4 1 2 3 4
	 * 1이상의숫자를입력하세요: 0 잘못입력하셨습니다.
	 * 
	 */
	public void method1() {
		
		
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		if(num >= 1) {
			for(int i=1;i<=num;i++) {
				System.out.println(i+" ");
			}
		} else {
			System.out.println("잘못 입력 하셨습니다.");
		}
	}
}
