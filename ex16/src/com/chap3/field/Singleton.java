package com.chap3.field;

/*
 * 디자인 패턴(Design Pattern)
 * 소프트웨어 설계에서 자주 등장하는 문제를 해결 하기 위한 방법
 * 	- 싱글톤패턴 : 단 하나의 인스턴스만 생성 하도록 하는 방법
 * 				로그 관리, 커넥션 관리, 설정 관리
 */
public class Singleton {

	private static Singleton singleton = new Singleton();
	
	// 외부에서 생성 할수 없도록 생성자의 접근 제한을 private 으로 지정
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	// 인스턴스 멤버(new) <-> 클래스 멤버(static)
	public static Singleton getInstance() {
		return singleton;
	}

}
