package com.chap3.field;

public class StaticFinalField {

	/*
	 * 1. final 필드
	 * 	- 초기값이 지정되면 더이상 수정 할수 없다!
	 *  - 초기화 
	 *  	1. 선언과 동시에 초기화
	 *  	2. 생성자를 통한 초기화
	 *  
	 * 2. 상수 필드(static final 필드)
	 * 	- 불변의 값 
	 * 	- 상수는 객체마다 저장할 필요가 없이 공유하는 목적을 띠고 있다!!
	 * 		(즉, final 필드는 객체마다 저장 되고, 생성자를 통해 여러값을 설정 할 수 있다)
	 *  - 상수의 이름은 모두 대문자로 작성 한다. 만약 여러 단어가 혼합되었다면 _로 구분한다
	 *  - 한번 초기값이 지정 되면 변경 할 수 없다 
	 */
	public static final int MAX_LEVEL = 99;
	

}
