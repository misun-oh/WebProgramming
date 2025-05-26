package com.object.practice;

// DTO, VO
public class Member {
	private String name;
	private String id;
	private String password;
	private int age;

	// 기본 생성자
	public Member() {
		System.out.println("기본 생성자 호출=======");
	}

	// 생성자의 오버로딩 - 매개변수의 갯수와 타입
	public Member(String name, String id){
		this();
		System.out.println("생성자 호출=======" + name+","+ id);
		this.name = name;
		this.id = id;
	}
	
	// 오버로딩이 아님!!! -> 타입과 갯수가 같다!!!!!
//	public Member(String id, String name){
//		this.name = name;
//		this.id = id;
//	}
	
	public Member(String name, String id, String password, int age) {
//		super(); // 부모의 필드, 메서드에 접근 할때 super 키워드를 사용
//		this.name = name;
//		this.id = id;
		// 생성자를 호출하여 필드의 값을 초기화
		// 첫번째 줄에 와야함!
		this(name, id);
		System.out.println("매개변수 생성자 호출!!" + name + ", "+ id + ", "+ password + ", "+ age);
		this.password = password;
		this.age = age;
	}

	
	
	
	// 메서드 login(), logout()
	// 접근제한자 반환타입 메서드명(매개변수타입 매개변수명) {}
	// id, pw를 외부로 받아와서 값을 확인
	public boolean login(String id, String pw) {
		boolean res = false;
		// this.id = 필드에 저장된 값
		// id = 매개변수로 넘어온 값
		if("hong".equals(id) && "12345".equals(pw)
				//id != null && id.equals("hong")
		) {
			res = true;
			//return true;
		}
		return res;
	}
	
	
	// void : 반환타입 없음
	public void logout(String id) {
		
	} 
	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// get + 필드이름 
	// -> 단어와 단어가 만나면 두번째단어의 첫글자는 대문자
	// -> 카멜표기법
	public String getId() {
		// id 필드의 값을 반환
		return id;
	}
	
	// 외부로 부터 필드에 세팅할 값을 받아와서 필드에 값을 저장
	public void setId(String id) {
		// 지역변수명과 필드명이 동일 한경우, 지역변수가 우선됨
		// 필드에 접근 하기 위해서 this 키워드를 사용!
		this.id = id;
	}

	public String info() {
		return name + ", " + id + ", " + age;
	}
	
	/*
	 * Member 필드정보를 문자열로 반환
	 */
//	public String info() {
//		return name + ", " + id + ", " + age;
//	}
}
