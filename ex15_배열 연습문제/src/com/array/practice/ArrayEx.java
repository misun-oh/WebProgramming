package com.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx {
	/*
	 * 길이가10인 정수형 배열을 만들고 반복문을 이용하여 순서대로 배열 인덱스에 넣은 후 그 값을 다음과 같이 출력
	 */
	public void method1() {
		// 선언과 동시에 배열의 값을 초기화
		// int intArr[] = {1,2,3,4,5,6,7,8,9,10};
		// 정수를 저장할 수 있는 공간 10개를 생성
		int intArr[] = new int[10];

		// for(int num:intArr) {

		// 배열에 값을 입력
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = i + 1;
			// System.out.println("intArr["+i+"] : " + intArr[i]);
			System.out.print(intArr[i] + " ");
		}
		System.out.println("===============");
		// 배열의 값을 출력
		for (int num : intArr) {
			System.out.print(num + " ");
		}
	}

	/*
	 * 길이가10인 정수형 배열을 만들고 반복문을 이용하여 역순으로 배열 인덱스에 넣은 후 그 값을 다음과 같이 출력
	 * 
	 * 10 9 8 7 6 5 4 3 2 1
	 */
	public void method2() {
		int intArr[] = new int[10];
		// 배열에 값을 입력하는 반복문
		// i는 0부터 9까지 1씩 증가하면서 코드블럭을 실행
		for (int i = 0; i < intArr.length; i++) {
			// intArr.length = 10
			intArr[i] = intArr.length - i;
		}
		// 배열에 값을 출력하는 반복문
		for (int num : intArr) {
			System.out.print(num + " ");
		}
	}

	Scanner s = new Scanner(System.in);

	/*
	 * 사용자에게 입력 받은 양의 정수 만큼 
	 * 배열 크기를 할당하고 1부터 입력 받은 값까지 배열에 초기화한 후 출력
	 */
	public void method3() {
		System.out.println("양의 정수 : ");
		int count = s.nextInt();
		int intArr[] = new int[count];
		// 배열의 방에 값을 입력
		for(int i=0;i<intArr.length;i++) {
			intArr[i] = i+1;
		}
		// 배열의 값을 출력
		for(int num:intArr) {
			System.out.print(num + " ");
		}
	}
	
	public void method4() {
		String menu[] = new String[5];
		menu[0] = "짜장면";
		menu[1] = "탕수육";
		for(String food : menu) {
			System.out.println(food);
		}
	}
	
	public void method5() {
		System.out.println("메뉴갯수 : ");
		int cnt = s.nextInt();
		s.nextLine();
		
		if(cnt>0) {
			// 메뉴갯수만큼 배열을 생성
			String menu[] = new String[cnt]; 	
			for(int i=0;i<menu.length;i++) {
				System.out.println(i + "번째 메뉴 : ");
				menu[i] = s.next();
			}
			
			//System.out.println(Arrays.toString(menu));
			String msg = Arrays.toString(menu);
			System.out.println(msg);
			
		} else {
			System.out.println("양수를 입력 하셔야 합니다!");
		}
		
	}
	
	public void method5_1() {
		// 메뉴 갯수만큼 방을 만들어 줍시다
		System.out.print("메뉴 갯수 : ");
		// 사용자의 입력을 대기 ( 사용자가 값을 입력하고 엔터를 누를때까지 ) 
		int cnt = s.nextInt();
		String menu[] = new String[cnt];
		
		for (int i=0;i<cnt;i++) {
			System.out.print("메뉴 : ");
			String str = s.next();
			menu[i] = str;
		}
		
		System.out.println(Arrays.toString(menu));
		// 추첨
		int num = (int)(Math.random()*cnt);
		// 추첨결과 출력
		System.out.println(menu[num] + "가 선택 되었습니다.");
		System.out.println("방번호 : " + num);
		
	}
}











