package com.exception.practice;

import java.util.Scanner;

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
	
	
	public void method3(String str) {
		//str.substring(3); <-- 강제종료
		// null을 매개변수로 입력했을때 -> NullPointException 
		try {			
			str.substring(3);
			System.out.println(str);
		
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
			System.out.println("==============");
			System.out.println(e.getMessage()); // 예외 메세지
			System.out.println("==============");
			System.out.println(e); // 예외 종류, 예외 메세지
			System.out.println("==============");
			e.printStackTrace(); // 예외 종류, 예외 메세지, 예외가 발생한 곳을 추적
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			System.out.println("예외에 상관없이 실행 하는 블록");
		}
	}
	
	public void method4() {
		try {
			// 라이브러리를 사용할 경우, 해당 라이브러리가 추가되었는지 아닌지를 확인
			// 예외를 던지고(throws) 메서드의 경우 예외에 대한 처리가 필요하다
			// 	1. throws 키워드를 이용해서 호출한곳으로 던지기 
			//  2. try/catch 블럭으로 묶어주기
			Class.forName("java.lang.StringA");
			System.out.println("java.lang.String 클래스가 존재합니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스를 찾을 수 없습니다.");
			System.out.println("라이브러리가 추가되었는지 확인 해주세요");
			e.printStackTrace();
		} finally {
			// 자원에 대한 반납
		}
	}
	
	
	Scanner s = new Scanner(System.in);
	
	public int getInt(String msg) {
		int i = 0;
		while(true) {
			try {
				System.out.println(msg);
				
				i=s.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력 가능 합니다.");
				s.next();
			}	
		}
		return i;
	}
	
	// 사용자 정의 예외 발생 시키기
	public void method5() throws UserException {
		throw new UserException();

	}
	
}







