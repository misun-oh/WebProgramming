package com.chap1.method;

/*
 * 클래스의 구조
 * - 필드(전역변수)
 * 		객체의 속성을 정의
 * 		[접근 제한자] 자료형 필드명;
 * - 생성자
 * 		객체의 필드를 초기화를 담당
 * 		사용할 준비 = 메모리 올라가야 사용할 수 있다
 *		// 기본생성자 - 매개변수가 없으면 기본생성자
 *			= 클래스에 생성자가 없는경우 컴파일러에 의해 하나의 기본생성자를 제공
 * 		[접근 제한자] 클래스명 (){}
 * 		[접근 제한자] 클래스명 (매개변수타입 매개변수명){}
 * - 메서드
 * 		기능 구현 = 동사적 구현
 * 		[접근 제한자] 반환타입 메서드명 (매개변수타입 매개변수명, ...){}
 * 
 * 🍀 접근제한자 : 외부에서 접근 할 수 있는 범위를 지정 
 * 		public(+) > protected(#)> default(~) > private(-)
 * 		default : 같은 패키지
 * 
 */
public class Student {
	// 필드(전역변수) : 클래스 내부 어디서나 사용이 가능
	private String name = "";
	// 학번 - 정수
	private int id;
	// 나이 - 정수
	private int age;
	// 주소 - 문자열
	private String address="";
	// 성별 - 문자열
	private String gender;
	
	public Student() {
	}
	
	// 생성자 - 생성자를 만들면 더이상 기본 생성자를 제공해주지 않는다 
	// 기본생성자가 필요하다면 추가로 만들어 줘야 한다
	public Student(String name, int id, int age, String address, String gender) {
		//super(); // 나의 부모의 기본 생성자를 호출
		// name => 지역변수
				
		// 지역변수와 전역변수의 변수명 같은때 전역변수에 접근 하기 위해서 this 키워드를 사용한다
		this.name = name;
		this.id = id;
		this.age = age;
		this.address = address;
		this.gender = gender;
	}
	
	/*
	 * 부모가 가진 메서드를 재정의
	 */
	@Override
	public String toString() {
		String msg =
					"=========="
					+ "\n이름 : " + name 
					+ "\n나이 : " + age
					+ "\n학번 : " + id
					+ "\n주소 : " + address
					+ "\n성별 : " + gender
					+ "\n==========";
		
		return msg;
	}

	/*
	 * 필드에 접근해서 값을 반환 하는 메서드
	 * 필드의 접근제한자가 private인 경우, 직접 접근을 막고 메서드를 이용한 접근을 제공 한다
	 * 1) getter메서드
	 * 	- 접근제한자가 public이다
	 * 	- 하나의 필드값을 반환한다
	 * 	- 메서드명은 getXXX()이다
	 * 	- 매개변수가 없다
	 * 	- 반환타입을 명시해야한다
	 */
	public String getName() {
		return name;
	}
	/*
	 * 필드에 접근해서 값을 세팅해주는 메서드
	 * 
	 * 2) setter메서드
	 * 	- 접근제한자가 public이다
	 * 	- 하나의 필드값을 수정 하는 역할
	 * 	- 메서드명 setXXX()이다
	 * 	- 값을 수정하기 위해서는 수정하려는 필드의 타입과 동일한 타입의 매개변수를 받아 와야한다
	 * 	- 반환타입이 없다
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}















