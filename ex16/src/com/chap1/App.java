package com.chap1;

import com.chap1.method.Student;

public class App {
	public static void main(String[] args) {
		// 변수만을 가지고 프로그램에서 필요한 객체를 만들어 본다면..
		String name = "뽀로로";
		int age = 4;
		
		String name1="크롱";
		int age1 = 3;
		
		// 기본생성자를 이용한 객체생성
		Student pororo = new Student();
		// setter 메서드를 이용해서 필드값을 세팅
		pororo.setId(1);
		pororo.setName("뽀로로");
		
		// 매개변수가 있는 생성자를 이용한 객체 생성
		// 객체 생성시 필요한 파라메터를 전달 한다
		Student krong = new Student("크롱", 2, 3, "성남시", "남");
		System.out.println(krong);
		
		int id = pororo.getId();
		String address = pororo.getAddress();
		System.out.println("pororo : " + pororo);
		
		// 필드(전역변수)는 선언만 할 경우 타입의 기본값으로 초기화 된다
		System.out.println("address : " + address);
		System.out.println("id : " + id);
		
		// 학생 배열을 만들고 학생3명을 생성하여 배열에 추가하시오
		// 배열을 돌면서 학생정보를 출력 하시오
		Student[] students = new Student[5];
		students[0] = krong;
		students[1] = new Student("우승우", 1111, 19, "태평로 12", "남");
		
		for(int i=0;i<students.length;i++) {
			System.out.println(students[i]);
		}
		
		
	}
}
