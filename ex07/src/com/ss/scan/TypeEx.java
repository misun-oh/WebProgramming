package com.ss.scan;

import java.util.Scanner;

public class TypeEx {
	/**
	 * F11 -> 실행을 담당
	 * @param args
	 */
	public static void main(String[] args) {
		// 1. 생성
		TypeEx te = new TypeEx();
		// 2. 변수명으로 접근
		//te.declear();
		//te.inputByScanner();
		//te.inputByScanner2();
		te.autoCasting();
	}
	
	private void declear() {
		/*
		 * 변수의 선언
		 * 		자료형(타입) 변수명;
		 * 		
		 * 변수의 값을 초기화(할당)
		 * 		변수명 = 값(리터럴);
		 * 		메모리에 올라갑니다. -> 값을 초기화(할당) 하기 전에 사용할 수 없다!
		 * 
		 * 변수의 선언 + 할당
		 * 		자료형(타입) 변수명 = 값;
		 * 
		 * (=) 대입연산자
		 * 		오른쪽에 있는 값을 왼쪽에다가 대입
		 * */
		// 정수형 변수를 선언해봅시다. 변수명은 num으로 한다.
		int num;
		num = 1;
		
		// 중복된 이름 사용 불가!
		//char num = 1;
		
		// 논리값 isTrue값을 선언하고 초기값을 false로 지정하세요
		boolean isTrue = false;
		// isTrue변수의 값을 true로 변경 
		// 변수명 = 값
		isTrue = true;
		// 실수값을 저장 할수 있는 변수를 선언하고 초기값을 3.14로 지정하세요
		double d = 3.14;
		// name 변수를 선언하고 삼성캠퍼스를 입력하고 출력 해봅시다
		// 이스케이프 문자
		String name = "\"삼성캠퍼스\"";
		name = "\"" + name + "\"";
		// 반환타입이 없는경우 변수를 초기화 할 수 없다
		System.out.println(name);
		
		
		// 문자열에 숫자가 저장된 경우
		// 연산이 불가능! -> 연산을 하기 위해서 형변환을 해야한다
		String str = "10";
		// 래퍼클래스 : 기본타입의 객체형
		// 문자를 숫자로 형변환 - 숫자가 들어있는경우 변환 숫자가 아닌경우 오류
		int num2 = Integer.parseInt(str);
		
		
		/*
		 * 변수의 명명 규칙
		 * 
		 * 1. 대소문자를 구분
		 * 2. 예약어를 사용할 수 없다.
		 * 3. 숫자로 시작할 수 없다.
		 * 4. 특수문자는 '_', '$' 만 사용이 가능 합니다.
		 *
		 * */
		int Age; // 대분자로 시작하는것은 추천하지 않음!
		int age;
		int _age;
		int $_age;
		// int 1age; // 숫자가 앞에 올 수 없다
		// int #age; // 특수문자는 _, $만 사용 가능
		// int class; // 예약어 사용 불가
		
	}
	
	// 매개변수 없고 반환이 없는 메서드 
	private void inputByScanner() {
		// 콘솔창에서 사용자의 입력을 받아 올수 있다
		Scanner scanner = new Scanner(System.in);
		/* 
		 * 문자열, 정수, 실수의 입력을 받아서 반환 하는 역활
		 * 
		 * scanner.nextLine() : 사용자가 입력한 값을 모두 읽어온다. (문자열)
		 * scanner.next() : 사용자가 입력한 값 중에 공백이 있을 경우 공백 이전까지의 값만 읽어온다.
		 * scanner.nextInt() : 정수를 입력받을 때 사용한다.
		 * scanner.nextDouble() : 실수를 입력받을 때 사용한다.
		 * ... 그 밖에 byte, boolean 등의 기본 자료형을 입력받을 때도 마찬가지로 nextXXX()로 입력받으면 된다. 
		 */
		
		// 사용자가 문자열을 입력후 엔터가 입력될 때까지 대기
		String str = scanner.next();
		String str1 = scanner.next();
		String str2 = scanner.next();
		String str3 = scanner.next();
		
		System.out.println("str : " + str);
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		
		// 엔터가 버퍼에 남아 있어서 nextLine() 메서드를 이용해서 엔터를 제거 후 다음 입력을 받을 수 있다
		// scanner.nextXXX() 메소드 뒤에 scanner.nextLine() 메소드를 사용하게 된다면 버퍼에 남아있는 
		// '엔터'를 빼주기 위해서 scanner.nextLine() 메소드를 한 번더 써야한다.
		String str4 = scanner.nextLine();
		// a b c d
		String str5 = scanner.nextLine();
		System.out.println("str4 : " + str4);
		System.out.println("str5 : " + str5);

	}
	
	private void inputByScanner2() {
		String name;
		int age;
		double height;
		
		// Scanner 객체를 생성
		Scanner scanner = new Scanner(System.in);
		// 사용자로 부터 이름, 나이, 키를 입력 받아서 출력 해봅시다
		// 키는 소수점 첫째자리까지 입력 합니다
		System.out.print("이름 : ");
		name = scanner.next();
		System.out.print("나이 : ");
		age = scanner.nextInt();
		System.out.print("키(소수점1자리까지) : ");
		height = scanner.nextDouble();
		
		System.out.println("이름 : " + name); 
		System.out.println("나이 : " + age); 
		System.out.println("키 : " + height);
		
		System.out.println("당신의 이름은 " + name + "이고 나이는 " + age + "세, 키는 " 
								+ height + "cm" + "입니다.");

		/* 형식문자열 출력
		 %s : 문자
		 %d : 정수
		 %f : 실수
		 */
		System.out.printf("당신의 이름은 %s이고 나이는 %d세, 키는 %.2fcm 입니다", name, age, height);
	}
	
	/*
	 * 형변환
	 * 
	 * - 연산은 같은 종류의 데이터 끼리만 가능하다
	 * 
	 * - 자동형 변환 (묵시적 형변환)
	 * 		개발자가 신경쓸 필요가 없다
	 * 		데이터 표현 범위가 작은 자료형이 큰 자료형으로 변환 될때 발생
	 * 		ex) int -> double
	 * - 강제형 변환 (명시적 형변환)
	 * 		(타입) 값;
	 * 		강제 형변환의 경우 데이터의 손실이 발생 할 수 있다
	 * 		
	 * */
	private void autoCasting() {
		int height = 163;

		// 묵시적 형변환
		double h = height; // 163.0
		System.out.println("h : " + h);

		// int/int = int
		// int/double = double
		// 연산시 타입이 일치해야 연산이 가능 -> double/double = double
		double height_m = 163/100.0;
		System.out.println("height_m : " + height_m);
		
		// 명시적 형변환
		height = (int) height_m;
			
	}
	
	
	
}
