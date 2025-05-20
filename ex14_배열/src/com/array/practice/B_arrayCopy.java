package com.array.practice;

import java.util.Arrays;

public class B_arrayCopy {
	/*
	 * 배열의 복사
	 *  - 얖은 복사 : 배열의 주소만 복사
	 *  - 깊은 복사 : 동일한 새로운 배열을 하나 생성
	 *  
	 */
	public void method1() {
		// 얕은복사
		int origin[] = {1,2,3,4,5};
		int copy[] = origin;
		
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copy :" + Arrays.toString(copy));
		
		copy[3]=44;
		System.out.println("copy[3]=44 변경");
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copy :" + Arrays.toString(copy));
		
		// 주소값 확인
		System.out.println("origin.hashCode() : " + origin.hashCode());
		System.out.println("copy.hashCode() : " + copy.hashCode());
		
	}

	/*
	 * 1. 반복문을 활용한 깊은 복사
	 */
	public void method2() {
		int origin[] = {1,2,3,4,5};
		// ArrayIndexOutOfBoundsException
		//int copy[] = new int[3];
		int copy[] = new int[5];
		for(int i=0;i<origin.length;i++) {
			copy[i] = origin[i];
			System.out.println("i : " + i);			
		}
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copy : " + Arrays.toString(copy));
		copy[3] = 44;
		System.out.println("변경후");
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copy : " + Arrays.toString(copy));
		
		System.out.println("origin.hashCode() : " + origin.hashCode());
		System.out.println("copy.hashCode() : " + copy.hashCode());
		
	}
	
	/*
	 * 2. System 클래스에서 제공하는 arraycopy() 메소드를 이용한 깊은 복사
	 */
	public void method3() {
		int origin[] = {1,2,3,4,5};
		int copy[] = new int[10];
		// System.arraycopy(원본 배열이름, 복사 시작 인덱스, 복사본 배열명, 복사본 배열의 복사 시작 위치, 복사할 길이);
		System.arraycopy(origin, 0, copy, 3, origin.length);
		
		System.out.println("copy : " + Arrays.toString(copy));
		
		System.out.println("origin.hashCode() : " + origin.hashCode());
		System.out.println("copy.hashCode() : " + copy.hashCode());
		
	}
	
	/*
	 *  3. Arrays 클래스에서 제공해하는 copyOf() 메소드를 이용한 깊은 복사
	 */
	public void method4() {
		int origin[] = {1,2,3,4,5};
		// Arrays.copyOf(원본 배열명, 복사할 길이)
		int copy[] = Arrays.copyOf(origin, 10);
		
		System.out.println(Arrays.toString(copy));
		System.out.println("origin.hashCode() : " + origin.hashCode());
		System.out.println("copy.hashCode() : " + copy.hashCode());
	}
	
	/*
	 * 4. clone() 메소드를 이용한 깊은 복사
	 */
	public void method5() {
		int origin[] = {1,2,3,4,5};
		int copy[] = origin.clone();
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(copy));
		System.out.println("origin.hashCode() : " + origin.hashCode());
		System.out.println("copy.hashCode() : " + copy.hashCode());
	}
	
}
