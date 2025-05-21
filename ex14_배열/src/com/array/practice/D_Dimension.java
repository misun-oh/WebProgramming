package com.array.practice;

/*
 * 다차원 배열
 */
public class D_Dimension {
	/*
	 * 1) 이차원 배열 선언
	 * 	자료형[][] 배열명;
	 *  자료형 배열명[][];
	 *  자료형[] 배열명[];
	 *  
	 * 2) 이차원 배열의 할당
	 *  배열명 = new 자료형[행크기][열크기];
	 *  
	 * 3) 이차원 배열의 선언과 동시에 할당
	 *  자료형[][] 배열명 = new 자료형[행크기][열크기];
	 *  
	 * 4) 이차원 배열의 초기화 
	 * 	- 인덱스로 접근해서 초기화
	 * 	  배열명[0][0] = 값1;
	 *  - 선언과 동시에 초기화
	 *    자료형[][] 배열명 = 
	 *    			{
	 *    				{1,2,3}
	 *    				, {1,2}
	 *    				, {1,2,3,4,5}
	 *    			}
	 *  - 반복문을 이용한 초기화
	 *  
	 */
	public void method1() {
		int[][] array = new int[4][5];
		
		//array = new int[3][5];
		
		// 1. 초기값 -> 2. 조건 -> 3. 코드블럭
		// 4. 증감식 -> 2. 조건 -> 조건이 false가 될때까지
		System.out.println("array.length : " + array.length);
		for(int i=0;i<array.length;i++) {
			//array[i] = new int[]{1,2,3};
			System.out.println(i + "번째 행");
			for(int j=0;j<array[i].length;j++) {
				array[i][j] = i*5 + j+1;
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 *   ■     ■ 
	 * ■ ■   ■ □ □
	 * ■ ■   ■ ■ ■
	 * ■ ■   ■ □ ■
	 * 
	 * 자리없음 = 9
	 * 빈자리 = 0 □
	 * 사용중인 자리 = 1 ■
	 */
	public void method2() {
		int[][] array = {
				{1, 1, 1, 1, 1}
				, {1, 1, 1, 1, 1}
				, {1, 1, 1, 1, 1}
				, {1, 1, 1, 1, 1}
		};
		
		array[0][0] = 9;
		array[0][2] = 9;
		array[0][4] = 9;
		
		array[1][3] = 0;
		array[1][4] = 0;
		array[3][3] = 0;
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				if(j == 2) {
					System.out.print("  ");
				}
				if(array[i][j] == 1) {
					System.out.print("■" + " ");					
				} else if (array[i][j] == 0) {
					System.out.print("□" + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
	}
	
	
	
}
