package com.inherit;

import java.util.Arrays;
import java.util.Scanner;

import com.inherit.practice.Employee;
import com.inherit.practice.Student;

public class App {

	public static void main(String[] args) {
		// 3명의 학생 정보를 기록할 수 있게 객체 배열 할당 (Student[])
		Student[] studentArr = new Student[3];
		// 위의 사용데이터 참고하여 3명의 학생 정보 초기화

		// 변수를 선언후 학생객체를 만들고 배열에 추가
		Student s1 = new Student("뽀로로", 24, 178.2, 70.0, 1, "정보시스템공학과");
		studentArr[0] = s1;
		
		// 배열에 직접 생성
		studentArr[1] = new Student("크롱", 25, 180.3, 80.2, 2, "경영학과");
		studentArr[2] = new Student("에디디", 26, 160.5, 45.6, 4, "정보통신학과");
		
		// 위의 학생 정보 모두 출력 
		for(Student s:studentArr) {
			System.out.println(s.information());
		}
		// 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당 (Employee[])
		Employee[] empArr = new Employee[10];
		Scanner s = new Scanner(System.in);
		int i=0;
		while(true) {
			System.out.println("i="+i);
			System.out.println("이름 : ");
			String name = s.next();
			System.out.println("나이 : ");
			int age = s.nextInt();
			System.out.println("키 : ");
			double height = s.nextDouble();
			System.out.println("몸무게 : ");
			double weight = s.nextDouble();
			System.out.println("급여 : ");
			int salary = s.nextInt();
			System.out.println("부서 : ");
			String dept = s.next();
			
			Employee emp = new Employee(name, age, height, weight, salary, dept);
			empArr[i] = emp;
			i++;
			if(i>=10) {
				break;
			}
			
			System.out.println("계속 하시겠습니까?");
			String input = s.next();
			// y,Y가 아니면 탈출
			// n=탈출, y=계속
			if(!"Y".equals(input.toUpperCase())) {
				break;
			}
		}
		System.out.println(Arrays.toString(empArr));
		for(Employee e:empArr) {
			if(e!=null) {
				System.out.println(e.information());				
			} else {
				break;
			}
		}
		// 사원들의 정보를 키보드로 계속 입력 받고 --> while(true) 무한 반복문을 통해 
		// 입력받은 정보들을 가지고 매개변수 생성자를 이용하여 객체 배열에 객체 생성 
		// 만약 10명이 모두 입력되면 반복문을 탈출 하도록 한다

		// 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가 
		// ‘n’일 경우 반복문을 탈출 한다.

		// 배열에 담긴 사원들의 정보를 모두 출력 

	}

}
