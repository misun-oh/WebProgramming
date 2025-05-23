package com.ex;
import java.util.Scanner;

public class 연습문제 {
	public static void main(String[] args) {
		// 조건문과 반복문 확인문제 
		// p140 확인문제 2번
		String grade = "a";
		int score1 = 0;
		
		switch (grade) {
			case "A","a" -> score1 = 100;
			case "B" -> {
				int result = 100-20;
				score1 = result;
			}
			default -> score1=60;
		}
		System.out.println("score1 : " + score1);
		
		System.out.println("==================");
		// 3번
		// 3의 배수를 출력
		int sum = 0;
		for(int i=1;i<=100;i++) {
		//for(int i=0;i<=100;i=i+3) {
			if(i%3 == 0) {
				System.out.println(i);
				// sum = sum + i
				sum += i;
			}
		}
		System.out.println("sum : " + sum);
		
		System.out.println("===================== 4번");
		// 주사위 : 1-6
		int num1, num2;
		// 두 수의 합이 5가 될때까지 반복
		while(true) {
			num1 = (int)(Math.random()*6)+1;
			num2 = (int)(Math.random()*6)+1;
			
			System.out.printf("(%d, %d)\n", num1, num2);
			if(num1+num2 == 5) {
				System.out.println("두 수의 합이 5입니다.");
				System.out.println("반복문 탈출");
				break;
			}
		}
		
		System.out.println("===================== 5번");	
		for(int x=1;x<=10;x++) {
			for(int y=1;y<=10;y++) {
				if(4*x + 5*y == 60)
					System.out.printf("(%d, %d)", x, y);
			}
			//System.out.println();
		}
		System.out.println();
		System.out.println("===================== 6번");
		for(int i=1;i<=5;i++) {
			//System.out.println(i);
			// i가 1일때 j는 1
			// i가 2일때 j는 1,2
			// i가 3일때 j는 1,2,3
			// i가 4일때 j는 1,2,3,4
			// 숫자 대신 * 을 출력
			for(int j=5;j>=i;j--) {
				//System.out.print(j);
				System.out.print("*");
				
			}
			// j의 반복이 끝나면 줄바꿈을 해준다
			System.out.println();
		}
		
		System.out.println();
		System.out.println("===================== 7번");
		
		int balance = 0;
		
		while(true) {
			System.out.println("=================");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("=================");
			System.out.print("선택 > ");
			int menu = scanner.nextInt();
			switch (menu) {
			case 1: {
				System.out.print("예금액 > ");
				balance += scanner.nextInt();
				break;
			}
			case 2: {
				System.out.print("출금액 > ");
				balance -= scanner.nextInt();
				break;
			}
			case 3 : {
				System.out.println("잔고 > " + balance);
				break;
			}
			case 4 : {
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			}
			default:
				System.out.println("메뉴를 잘 못 선택 하셨습니다.(1-4)");
			}
		}
	}
	
	static Scanner scanner = new Scanner(System.in);
}





