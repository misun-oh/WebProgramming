package com.ex;
public class 연습문제2 {
	public static void main(String[] args) {
		System.out.println("==============7번");
		
		int[] array = {1, 5, 3, 8, 2};
		int max = 0;
		for(int num : array) {
			if(max < num) {
				max = num;
			}
		}
		System.out.println("max : " + max);
		
		System.out.println("====================== 8번");
		int[][] arr = {
				{95, 86}
				, {83, 92, 96}
				, {78, 83, 93, 87, 88}
		};
		
		int sum=0, avg=0, cnt=0;
		// i = 0,1,2
		for(int i=0;i<arr.length;i++) {
			System.out.println("i ==== " + i);
			// i가 증가 할때마다 초기화
			int subTotal = 0;
			for(int j=0;j<arr[i].length;j++) {
				System.out.println(arr[i][j]);
				//sum += arr[i][j];
				subTotal += arr[i][j];
				cnt++;
			}
			// arr[i]방의 요소들의 합계/ 평균
			System.out.println("===== 소계 : " + subTotal);
			System.out.println("===== 평균 : " + subTotal/arr[i].length);
			sum += subTotal;
		}
		
		avg = sum/cnt;
		
		System.out.println("총 합계 : " + sum);
		System.out.println("총 평균 : " + avg);
		
		
		
	}
}
