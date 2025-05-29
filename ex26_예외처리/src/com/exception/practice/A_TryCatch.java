package com.exception.practice;

/*
 * try-catch 
 * 	 [ ] : 생략 가능
 *     try {
 *        // 예외가 발생할 가능이 있는 코드가 위치한다.
 *     } catch (Exception e) {
 *        // try 블록에서 예외가 발생하면 실행을 멈추고 catch 블록으로 이동하여 예외 처리 코드를 실행한다.
 *     } [finally {
 *        // 예외가 발생하지 않거나 예외가 발생해 catch 블록을 실행한 후에 무조건 실행되는 코드 블록이다.
 *        // finally 블록은 생략이 가능하다.
 *        // 자원의 반납/해제가 이루어진다
 *     }]
 * 
 */ 
public class A_TryCatch {

	public void method1() {
		try {
			System.out.println("method2 실행 전");
			method2();
			System.out.println("method2 실행 후");
		} catch (Exception e) {
			System.out.println("catch 블럭이 실행");
			e.printStackTrace();
		} finally {
			System.out.println("finally 블럭이 실행");
			System.out.println("예외발생과 상관 없이 실행 되는 블록");
		}

	}
	
	/*
	 * 강제로 예외를 발생 시켜 봅시다
	 * 메서드에 throws 구문이 작성됨
	 */
	private void method2() throws Exception {
		throw new Exception("강제로 예외 발생");
	}
}
