package com.object.service;

public class MemberService {

	public boolean login(String id, String pw) {
		// id = null;
		// null에 점을 찍으면 nullPointException이 발생 
		// 프로그램이 비 정상적으로 종료
		if("hong".equals(id) && "12345".equals(pw)) {
			return true;
		}
		return false;
	}

	// 기능 정의
	public void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
}
