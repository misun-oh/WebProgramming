package com.chap4.method;

import java.util.Arrays;

public class Overloading {

	@Override
	public String toString() {
		// 오버라이딩
		// 부모의 메서드를 재정의
		return "";
	}
	
	/*
	 * 메서드의 오버로딩
	 * 	- 한 클래스내에 같은 이름의 메서드를 여러개 정의 하는 것
	 *  - 매개변수의 타입(자료형) 개수와 순서가 다르게 작성 되어야 한다
	 *  - 매개변수명, 접근제한자, 반환형은 영향을 주지 않는다
	 *  - 호출시 전달되는 파라메터의 갯수, 타입에 따라 실행되는 메서드가 결정된다!!!
	 */
	private void test() {
	}
	
	private void test(int a) {
	}
	
	private void test(int a, int b) {
	}
	
	// 변수명만 다른것은 안된다!!!!!!!
//	private void test(int num1, int num2) {
//	}
	
	private void test(String str) {
	}

		
	
	// 1. 클래스명과 동일한 이름
	// 2. 반환타입이 없다
	// 3. new 연산자를 만나서 인스턴스(객체)를 생성하고 주소를 반환하는 역할
	// 4. 만약 생성자를 만들지 않으면 컴파일러에 의해서 기본생성자가 추가
	public Overloading() {
		// 필드에 대한 초기화
	}

	public Overloading(int a, int b) {
		// 필드에 대한 초기화
	}
	
	// 1. 매개변수도 없고 반환 타입도 없는 메서드
	private void method() {
		// 어떤 값도 반환 하지 않고 메서드 내용만 수행 후 종료
		System.out.println("method()가 호출 되었습니다.");
		// 메서드를 끝내는 용도로 return문을 사용 할 수 있다
		return;
		// return 1; 반환타입이 없는경우 반환값을 주면 오류가 발생
		//System.out.println("리턴문장 이후 출력문");
	}
	
	// 2. 매개변수는 없고 반환타입만 있는경우
	//    	getter 메서드
	private String method1() {
		// 반환타입과 반환값의 타입이 같아야 한다!!!!!!!!!
		//return "매개변수는 없지만 반환 값이 있는 메서드";
		String str = "매개변수는 없지만 반환 값이 있는 메서드";
		return str;
	}
	
	// 3. 매개변수는 있고 반환타입이 없는경우
	// 		setter 메서드
	private void method2(String str) {
		System.out.println("str : "+str);
	}
	
	// 4. 매개변수도 있고 반환 타입도 있는 메서드
	private int method4(int num1, int num2) {
		return num1+num2;
	}
	
	// 5. 매개변수로 객체를 전달 받는 메서드
	// 매개변수로 객체가 전달되거나 객체가 반환 되는경우
	// 🍀🍀🍀🍀🍀객체의 참조값(주소)가 전달 된다!!!!
	// 매개변수의타입 매개변수이름
	public User method5(User user) {
		user.setAge(4);
		user.setName("뽀로로");
		return user;
	}
	
	// 6. 매개변수가 가변인자인 경우
	// 	- 가변인자는 매개변수의 맨 마지막에 위치해야 한다 
	// 	- java 1.5부터 지원
	public void method6(int[] numbers) {
		System.out.println(numbers.length);
		System.out.println(Arrays.toString(numbers));
	}
	
	public void method7(String name, int ... numbers) {
		System.out.println(name);
		System.out.println(numbers.length);
		System.out.println(Arrays.toString(numbers));
	}
	
	public void method8(String ... names) {
		System.out.println(names.length);
		System.out.println(Arrays.toString(names));

	}
	
	
	
}
