package com.control;

public class ContinueEx {

	/*
	 * continue 문 
	 *   [표현법]
	 *     반복문(조건식) {
	 *       [continue;]
	 *     }
	 *     
	 *  - 반복문 안에서만 사용 가능하고 continue를 만나게 되면 다음 구문들은 실행하지 않고
	 *    가장 가까운 반복문의 조건식/증감식으로 이동한다.
	 */
	public static void main(String[] args) {
		// 1. 1부터 100까지 출력 하기 
		// 2. 1부터 100까지의 합을 구하고 출력 하기
		// 3. 짝수의 합만 구해서 출력 하기 - continue
		int sum = 0;
		for(int i=1;i<=100;i++) {
			//sum = sum + i;
			// 홀수이면 코드블럭을 실행하지 않고 다음 반복문으로 
			if(i%2==1) {
				continue;
			}
			System.out.println("i = " + i);
			sum += i;
		}
		System.out.println("sum = " + sum);
		
		
	}
}
