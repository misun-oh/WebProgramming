package com.lib.controller;

import com.lib.dao.MemberDao;
import com.util.ScannerUtil;
import com.vo.MemberVO;

public class LibraryController {
	
	MemberDao dao = new MemberDao();
	
	public LibraryController(){
		System.out.println("-------------------");
		System.out.println("성남 아트리움 도서관에 오신걸 환영 합니다.");
		System.out.println("-------------------");
	}
	
	// 로그인
	public void login() {
		System.out.println("로그인");
		
		String id = ScannerUtil.getString("ID : ");
		String pw = ScannerUtil.getString("PW : ");
		MemberVO member = dao.login(id, pw);
		if(member == null) {
			System.out.println("로그인 실패");
		} else {
			System.out.println(member.getName() + "님 환영 합니다.");
			return;
		}
		
	
		
	}
	
	// 사용자 메뉴
	public void userMenu(){
		
		
	}
	
	// 관리자 메뉴
	public void adminMenu(){
		System.out.println("관리자 메뉴    ============");
		System.out.println("1. 사용자 목록");
		System.out.println("2. 사용자 추가");
		System.out.println("3. 사용자 삭제");
		System.out.println("4. 종료");
		
		
	}
	
	
	
	
}
