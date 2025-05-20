package com.array.practice;

public class A_array {
	public void method1() {
		int num1 = 10;
		int num2 = 5;
		int num3 = 20;
		int num4 = 19;
		int num5 = 35;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
	}
	
	/**
	 * 배열
	 * 
	 * 1) 배열 선언
	 * 	자료형[] 배열명;
	 *  자료형   배열명[];
	 * 2) 배열 초기화
	 *  배열명 = new 자료형[배열크기];
	 * 3) 배열에 값을 저장 
	 *  배열명[방번호] = 값;
	 */
	public void method2() {

		int intArray[];
		// 0,1,2,3,4
		intArray = new int[5];
		// 선언과 동시에 초기화
		// 0,1,2,3,4
		int[] intArray1 = {15,20,25,30,35};
		int[] intArray2 = new int[]{15,20,25,30,35};
		//intArray1[0] = 0;
		System.out.println("intArray1.length : " + intArray1.length);

		// 반복문을 이용한 출력
		// i = 0 ~ 4
		for(int i=0;i<5;i++) {
			System.out.println(intArray1[i]);
		}
		for(int i=0;i<intArray1.length;i++) {
			intArray1[i] = i+1;
		}
		System.out.println("===================");
	}
	
	public void method3() {
		int intArr[] = new int[5];
		// 1부터 10까지의 정수중 임의의 수를 뽑아 intArr 0번째 방에 저장
		intArr[0] = (int)(Math.random()*10) + 1;
		intArr[1] = (int)(Math.random()*10) + 1;
		intArr[2] = (int)(Math.random()*10) + 1;
		intArr[3] = (int)(Math.random()*10) + 1;
		intArr[4] = (int)(Math.random()*10) + 1;
		
		System.out.println(intArr[0]);
		System.out.println(intArr[1]);
		System.out.println(intArr[2]);
		System.out.println(intArr[3]);
		System.out.println(intArr[4]);
	}
	
	public void method4() {
		int intArr[] = new int[5];
		
		for(int i=0;i<intArr.length;i++) {
			// 1부터 10까지의 정수중 임의의 수를 뽑아 intArr 0번째 방에 저장
			int num = (int)(Math.random()*10) + 1;
			// 배열의 방에 임의의 값을 저장
			intArr[i] = num;
			System.out.println(intArr[i]);
			//intArr[i] = (int)(Math.random()*10) + 1;
		}
		System.out.println("========================");
//		intArr[0] = (int)(Math.random()*10) + 1;
//		intArr[1] = (int)(Math.random()*10) + 1;
//		intArr[2] = (int)(Math.random()*10) + 1;
//		intArr[3] = (int)(Math.random()*10) + 1;
//		intArr[4] = (int)(Math.random()*10) + 1;
		for(int i=0;i<intArr.length;i++) {
			System.out.println(intArr[i]);
		}
//		System.out.println(intArr[0]);
//		System.out.println(intArr[1]);
//		System.out.println(intArr[2]);
//		System.out.println(intArr[3]);
//		System.out.println(intArr[4]);
		System.out.println("=======================");
		//향상된 for문
		// 배열의 요소들을 꺼내서 변수 num 에 저장하고 코드블럭을 실행
		for(int num:intArr) {
			System.out.println(num);
		}
	}
	
	public void method5() {
		// 정수타입의 길이가 10인 배열을 선언
		int intArr[] = new int[10];
		
		// 타입의 기본값으로 초기화 된다 p174
		for(int num:intArr) {
			System.out.println("num : " + num);
		}
		
		// 반복문을 이용해서 1-10까지의 임의의 수를 추출하고 배열에 저장
		
	}

	/*
	 * 반복이 없는 로또
	 */
	public void method6() {
		// 정수타입의 길이가 5인 배열을 선언
		int intArr[] = new int[5];
		
		for(int i=0;i<intArr.length;i++) {
			// 1부터 47까지의 정수중 임의의 수를 뽑아 배열에 순서대로 저장
			int num = (int)(Math.random()*47) + 1;
			intArr[i] = num;
			// 중복을 제거
			for(int j=0;j<i;j++) {
				System.out.println(j+"번방의 값과 비교 진행");				
				System.out.printf("num : %d, intArr[j] : %d\n", num, intArr[j]);
				if(intArr[j] == num) {
					System.out.println("중복발생");
					i--;
					break;
				}
			}
		}
		
		System.out.println("로또번호 : ");
		for(int num:intArr) {
			System.out.print(num + " ");
		}
		
		// 반복문을 이용해서 1-10까지의 임의의 수를 추출하고 배열에 저장
	}
	
	public int[] method7() {
		// 정수타입의 길이가 5인 배열을 선언
		int intArr[] = new int[5];
		
		for(int i=0;i<intArr.length;i++) {
			// 1부터 47까지의 정수중 임의의 수를 뽑아 배열에 순서대로 저장
			int num = (int)(Math.random()*47) + 1;
			intArr[i] = num;
			// 중복을 제거
			for(int j=0;j<i;j++) {
				System.out.println(j+"번방의 값과 비교 진행");				
				System.out.printf("num : %d, intArr[j] : %d\n", num, intArr[j]);
				if(intArr[j] == num) {
					System.out.println("중복발생");
					i--;
					break;
				}
			}
		}
//		System.out.println("로또번호 : ");
//		for(int num:intArr) {
//			System.out.print(num + " ");
//		}
		return intArr;
		
		// 반복문을 이용해서 1-10까지의 임의의 수를 추출하고 배열에 저장
	}
}











