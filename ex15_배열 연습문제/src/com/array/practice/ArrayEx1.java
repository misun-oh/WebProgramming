package com.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {
	/*
	 * 길이가 5인 String 배열을 선언하고 "사과", "블루베리", "포도", "복숭아", "참외"로 초기화한 후 배열 인덱스를 활용해서
	 * 블루베리을 출력
	 */
	public void method4() {
		// 선언
		String strArr[];
		strArr = new String[5];
		strArr[0] = "사과";
		strArr[1] = "블루베리";
		strArr[2] = "포도";
		strArr[3] = "복숭아";
		strArr[4] = "참외";

		String strArr1[] = null;
		strArr1 = new String[] { "사과", "블루베리", "포도", "복숭아", "참외" };
		System.out.println(strArr1[2]);

		// 선언과 동시에 초기화
		String strArr2[] = { "사과", "블루베리", "포도", "복숭아", "참외" };
		System.out.println(strArr2[1]);

	}

	Scanner s = new Scanner(System.in);

	/*
	 * "월" ~ "일"(요일)까지 초기화된 문자열 배열을 만들고 0부터 6까지 숫자를 입력 받아 입력한 숫자와 같은 인덱스에 있는 요일을 출력
	 * 범위에 없는 숫자를 입력시 "잘못 입력 하셨습니다.를 출력
	 */
	public void method5() {
		// index : 0 ~ 6
		String strArr[] = { "월", "화", "수", "목", "금", "토", "일" };

		while (true) {
			System.out.println("정수(0-6) : ");
			int num = s.nextInt();
			if (num > 6) {
				System.out.println("잘못 입력 하셨습니다.");
			} else {
				System.out.println(strArr[num]);
				break;
			}
		}

	}

	/*
	 * 사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언및 할당하고 배열의 크기만큼 사용자가 직접값을 입력하여 각각의 인덱스에
	 * 값을 초기화 하세요. 그리고 배열 전체값을 출력(나열)하고 각 인덱스에 저장된 값들의 합을 출력 하세요.
	 */
	public void method6() {
		System.out.println("배열의 길이 : ");
		int num = s.nextInt();
		int intArr[] = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.print(i + "번째 인덱스에 넣을값 : ");
			intArr[i] = s.nextInt();
		}
		int sum = 0;
		// 출력
		System.out.println(Arrays.toString(intArr));
		for (int res : intArr) {
			System.out.print(res + " ");
			sum += res;
		}
		System.out.println();
		System.out.println("총합 : " + sum);
	}

	/*
	 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고 1~10 사이의 무작위수를 발생 시켜 배열에 초기화 한후 출력하세요.
	 */
	private void method7() {
		// TODO Auto-generated method stub

	}
}
