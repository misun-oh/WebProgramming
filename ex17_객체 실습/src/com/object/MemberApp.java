package com.object;

import com.object.practice.Member;

public class MemberApp {

	public static void main(String[] args) {
		// 타입 변수명 = 값;
		// 참조타입 = 클래스명을 타입으로 사용
		Member member = new Member();
		member.setName("크롱");
		member.setId("user2");
		member.setPassword("4567");
		member.setAge(3);
		
		System.out.println(member.getName() + ", " + member.getAge());
		
		Member member1 = new Member("뽀로로", "user1", "1234", 4);
		System.out.println(member1.getName() + ", " + member1.getAge());
		
		System.out.println(member1.info());
		
		
	}

}
