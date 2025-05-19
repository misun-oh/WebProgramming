package com.loop.practice;

import java.util.Scanner;

public class LoopEx {

	/**
	 * 로또 무작위를 이용하여 1 ~ 46까지의 수중 랜던한 수 5개를 출력 해주세요
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
	 * 구구단 2단 ~ 9단 까지 출력 하세요
	 */
	public void method00() {
		// 2단 ~ 9단
		for (int dan = 2; dan < 10; dan++) {
			// 2단 출력
			// 변수 i는 반복문이 실행 되면서 1부터 9까지 증가합니다
			// i = 1 ~ 9
			System.out.println(dan + "단");
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			}

		}
	}

	/**
	 * 정수를 입력 받고 정수에 해당하는 단을 출력 하시오 구구단
	 */
	public void method01() {
		while (true) {
			int dan = scanner.nextInt();
			// i : 1 ~ 9
			for (int i = 1; i < 10; i++) {
				System.out.println(dan + "단");
				System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			}
		}
	}

	Scanner scanner = new Scanner(System.in);

	/*
	 * 사용자로 부터 한 개의 값을 입력 받아 1부터 그 숫자 까지의 숫자들을 모두 출력 하세요. 단, 입력한 수는 1보다 크거나 같아야 합니다.
	 * 만일 1 미만의 숫자가 입력 됐다면 "잘못입력하셨습니다."를 출력하세요.
	 * 
	 * (for문이용) ex. 1이상의숫자를입력하세요: 4 1 2 3 4 1이상의숫자를입력하세요: 0 잘못입력하셨습니다.
	 * 
	 */
	public void method1() {
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		if (num >= 1) {
			for (int i = 1; i <= num; i++) {
				System.out.println(i + " ");
			}
		} else {
			System.out.println("잘못 입력 하셨습니다.");
		}
	}

	/*
	 * 1미만의 숫자가 입력 됐다면 "잘못입력하셨습니다. 다시입력해주세요."가 출력 되면서 다시 사용자가 값을 입력 하도록 하세요.
	 */
	public void method2() {
		while (true) {
			System.out.println("1이상의 정수를 입력 : ");
			int num = scanner.nextInt();
			if (num < 1) {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			} else {
				for (int i = 1; i <= num; i++) {
					System.out.print(i + " ");

				}
				// 1이상의 수가 입력 되었다면 반복문을 탈출
				break;

			}
		}

	}

	/*
	 * 사용자로 부터 한 개의 값을 입력 받아 1부터 그 숫자 까지의 모든 숫자를 거꾸로 출력 하세요. 단, 입력한 수는 1보다 크거나 같아야
	 * 합니다. (for문이용)
	 * 
	 * 반복문을 이용해서 사용자가 잘못 입력 하였을 경우 다시 입력 받을수 있도록 하세요
	 */
	public void method3() {
		while (true) {
			System.out.println("1이상의 정수를 입력 : ");
			int num = scanner.nextInt();
			if (num < 1) {
				System.out.println("잘못 입력 하셨습니다.");
			} else {
				for (int i = num; i >= 1; i--) {
					System.out.print(i + " ");
				}
				System.out.println();
				break;
			}
		}

	}

	/*
	 * 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 출력하세요.
	 */
	public void method5() {
		System.out.println("정수 : ");
		int num = scanner.nextInt();
		int sum = 0;
		// i = 1,2,3..
		for (int i = 1; i <= num; i++) {
			sum += i;
			if (i < num) {
				System.out.print(i + " + ");
			} else {
				System.out.print(i + " = ");
			}
		}
		System.out.println(sum);
	}

	public void method6() {
		// 1. 자리 바꾸기
		int num1 = 5;
		int num2 = 2;

		int temp = num1;
		num1 = num2;
		num2 = temp;

		for (int i = num1; i <= num2; i++) {
			System.out.println(i + " ");
		}

		// 2. 최대값, 최소값
		num1 = 5;
		num2 = 2;
		int min = 0, max = 0;
		max = Math.max(num1, num2);
		min = Math.min(num1, num2);
		System.out.println("max : " + max);
		System.out.println("min : " + min);

		for (int i = min; i <= max; i++) {
			System.out.println(i);
		}

	}

	/*
	 * 사용자로부터 두개의 값을 입력 받아 그 사이의 숫자를 모두 출력 하세요. 
	 * 만일 1미만의 숫자가 입력 됐다면 "1이상의 숫자만 입력해주세요"를 출력하세요.
	 */
	// 자리 바꾸기
	public void method6_1() {
		
		int num1, num2, temp;
		
		while(true) {
			System.out.println("정수1 : ");
			num1 = scanner.nextInt();
			System.out.println("정수2 : ");
			num2 = scanner.nextInt();
			
			if(num1 >= 1 && num2 >= 1) {
				if(num1 > num2) {
					temp = num1;
					num1 = num2;
					num2 = temp;
				}
				
				for (int i=num1;i<= num2;i++) {
					System.out.print(i + " ");
				}	
				break;
			} else {
				System.out.println("1 이상의 숫자만 입력 가능 합니다.");
			}
			
		}
	}
	
	// 메서드 이용하기
	public void method6_2() {
		int num1, num2, min, max;
		while (true) {
			System.out.println("정수1 : ");
			num1 = scanner.nextInt();
			System.out.println("정수2 : ");
			num2 = scanner.nextInt();
			
			if(num1 < 1 || num2 < 1) {
				System.out.println("1 이상의 숫자만 입력 가능 합니다.");
			} else {
				min = Math.min(num1, num2);
				max = Math.max(num1, num2);
				
				for(int i=min;i<=max;i++) {
					System.out.print(i + " ");
				}
				break;
			}
		}
		
	}
	
	public void method8() {
		while(true) {
			System.out.println("정수(1~9) : ");
			int num = scanner.nextInt();
			
			if(num >=1 && num <=9) {
				
				// j는 num부터 9보다 작거나 같을때까지 1씩 증가시키면서 반복해서 출력
				for(int j=num;j<=9;j++) {
					System.out.println("======== " + j + "단 =========");
					// 1 ~ 9
					for(int i = 1;i <= 9; i++) {
						System.out.printf("%d * %d = %d\n", j, i, j*i);
					}					
				}
				break;
			} else {
				System.out.println("1 ~ 9까지 정수 중 하나의 숫자를 입력 해야 합니다.");
			}			
		}
	}
	
}











