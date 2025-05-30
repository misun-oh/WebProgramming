package com.exception.practice;
/*
 *  UnCheckedException
 *    - RuntimeException을 상속하고 있는 예외들을 UnCheckedException이라 한다.
 *    - 컴파일 시 예외 처리 코드가 있는지 검사하지 않는 예외를 말한다.
 *    - RuntimeException 같은 경우엔 프로그램 실행할 때 문제가 발생되는 것이기 
 *    	때문에 충분히 예측이 가능하기 때문에 조건문들을 통해서 처리가 가능하다.
 *    
 *    
 *  RuntimeException의 후손들
 *    🍀🍀 ArrayIndexOutOfBoundsException : 배열의 접근에 잘못된 인덱스 값을 사용하는 경우 예외 발생
 *    - NegativeArraySizeException : 배열 크기를 음수로 지정한 경우 예외 발생
 *    - ArithmeticException : 나누기 연산에서 분모가 0인 경우 예외 발생
 *    🍀🍀 NullPointerException : Null인 참조 변수로 객체의 멤버 참조 시도 시 예외 발생
 *    🍀🍀 ClassCastException : 잘못된 Cast 연산자 사용 시 예외 발생
 */
public class B_UnCheckedException {
	public void method1(int num) {
		//System.out.println(10/num);
		if(num != 0) {			
			System.out.println(10/num);
		} else {
			System.out.println("0으로 나눌수 없어요!");
		}
	}
	
	public void method2() {
		try {
			int[] arr = new int[0];
			// 배열의 범위를 벗어난 경우
			//arr[0] = 1;
			arr[-1] = 1;			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위를 벗어났습니다.");
		}
	}
}
