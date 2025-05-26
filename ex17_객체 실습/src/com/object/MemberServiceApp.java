package com.object;

import com.object.service.MemberService;

public class MemberServiceApp {

	public static void main(String[] args) {
		// login() 메서드를 사용하기 위해서
		// MemberService 객체를 생성
		// 타입 변수명 = 값;
		MemberService service = new MemberService();
		boolean res = service.login("hong", "12345");
		System.out.println("res : " + res);
		if(res) {
			System.out.println("로그인 성공!!!");
			service.logout("hong");
		} else {
			System.out.println("로그인 실패(id, pw를 확인 해주세요)");
		}
		
		System.out.println();
		
	}

}
