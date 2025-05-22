package com.chap2;

import com.chap2.encapsulation.Student;

public class App {
	
	/*
	 * 추상화와 캡슐화
	 * 
	 * 1. 추상화
	 *   - 프로그램에서 사용할 객체들이 가진 공통의 특성을 파악하고 불필요한 특성들을 제거하는 과정을 말한다.
	 *   - 최종적으로 선정된 속성들을 가지고 어떤 자료형으로, 어떠한 변수명으로 사용할지 정리해서 코드로 작성한다.
	 *   
	 * 2. 캡슐화
	 *   - 추상화를 통해서 정의된 속성들과 기능을 하나로 묶어서 관리하는 기법 중 하나로
	 *     클래스의 가장 중요한 목적인 데이터 접근 제한을 원칙으로 외부로부터 데이터의 직접 접근을 막고
	 *     대신에 데이터를 간접적으로 처리하는 메소드들을 클래스 내부에 작성하여 제공하는 방법을 말한다.
	 *   - 객체의 필드, 메소드를 하나로 묶고 실제 구현 내용을 감추는 것을 말한다.
	 *   - 외부에서 객체의 내부를 알지 못하며 객체가 노출해서 제공하는 필드나 메소드만 이용할 수 있다.
	 * 
	 */
	public static void main(String[] args) {
		// 학생 객체 생성
		// class = 설계도
		// 객체 생성 - 인스턴스(메모리에 올라간 상태)
		// 타입 변수명 = new 타입()
		// 클래스의 이름을 타입으로 사용 
		Student pororo = new Student();
		pororo.setId(1);
		pororo.setName("뽀로로");
		// toString : 패키지명을 포함한 클래스의 이름 @ 주소 
		System.out.println(pororo.toString());
		System.out.println(pororo.information());
		
		System.out.println("==========================");
		
		Student pororo1 = new Student(1, "뽀로로");
		System.out.println(pororo1);
		System.out.println(pororo1.information());
		
		System.out.println("=========================");
		
		Student pororo2 = new Student(1, "뽀로로", 4, "성남시", "남", 80, 30);
		System.out.println(pororo2);
		System.out.println(pororo2.information());
		
		// 객체 생성 실습
		// 4명의 학생을 생성 해봅시다
		// new : 객체를 생성후 객체의 주소를 반환 한다!
		Student st1 = new Student(1, "뽀로로", 4, "태평로", "남", 100, 0); 
		Student st2 = new Student(2, "에디", 5, "수정구", "남", 70, 30); 
		Student st3 = new Student(3, "루피", 6, "성남시", "여", 90, 50); 
		Student st4 = new Student(4, "크롱", 7, "일산구", "남", 30, 50); 
		
		// 타입의 기본값 
		// null 이 들어있는 방 5개가 만들어 진다
		Student[] students = new Student[5];
		students[0] = st1;
		students[1] = st2;
		students[2] = st3;
		students[3] = st4;
		
		// i = 0 - 4
		// 평균성적
		// 모든 친구들의 평균
		for(int i=0;i<students.length;i++) {
			if(students[i] != null) {
				System.out.println(students[i].information());
			}
		}
		
		st1.setEngScore(85);
		System.out.println(st1.information());
		
		System.out.println(students[0].information());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
