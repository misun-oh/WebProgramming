package com.chap2.encapsulation;

public class Student {
	// 속성의 정의
	// 필드에 대한 초기값을 지정 하지 않은경우, 타입의 초기값으로 설정 된다
	// 		참조타입의 경우 null(참조하고 있지 않은 경우)
	// 		정수 : 0, 실수 : 0.0, boolean : false
	private int id;
	private String name;
	private int age;
	private String address;
	private String gender;
	private int mathScore;
	private int engScore;
	// 수학, 영어 점수의 평균
	// 생성자를 이용해서 초기화시 평균점수를 구한다
	// set메서드를 통해 수학점수나 영어점수가 변경되면 평균도 다시 구한다
	private double avg;
	
	// 기본 생성자
	public Student() {	
		System.out.println("==== 기본생성자");
	}
	
	// 매개변수가 있는 생성자 = 필드 초기화
	public Student(int id, String name) {
		System.out.println("==== 매개변수 있는 생성자");
		this.id = id;
		this.name = name;
	}
	
	// 매개변수가 있는 생성자
	public Student(int id, String name, int age, String address, String gender, int mathScore, int engScore) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.mathScore = mathScore;
		this.engScore = engScore;
		avg = getAvg();
	}

	// getter/setter : 외부에서 접근 해서 필드의 값을 변환 할수 있도록 메서드를 제공
	public int getId() {
		return id;
	}
	
	// 매개변수(또는 지역변수)의 이름과 필드(전역변수)의 이름이 같은 경우
	// 지역변수가 우선
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length()>5) {
			return;
		}
		this.name = name;
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
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
		// 점수가 변경되면 평균도 다시 계산한다
		this.avg = getAvg();
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
		// 점수가 변경되면 평균도 다시 계산한다
		// 함수의 실행결과 반환된 값이 avg 필드에 저장 됩니다
		this.avg = getAvg();
	}
	
	// 평균을 반환하는 메서드
	public double getAvg() {
		double avg = (engScore+mathScore)/2.0;
		return avg;
	}
	
	// 필드의 정보를 문자열로 반환
	public String information() {
		return "id : " + id + ", 이름 : " + name + ", 수학성적 : " + mathScore 
				+ ", 영어성적 : " + engScore + ", 평균 : " + getAvg();
	}

}
