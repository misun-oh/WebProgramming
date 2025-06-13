package com.lib.controller;

import com.lib.service.MemberService;
import com.util.ScannerUtil;
import com.vo.MemberVO;

public class LibraryController {
	
	MemberService service = new MemberService();
	public MemberVO loginMember = null;
	
	public LibraryController(){
		System.out.println("-------------------");
		System.out.println("성남 아트리움 도서관에 오신걸 환영 합니다.");
		System.out.println("-------------------");
	}
	
	// 로그인
	public void login() {
		System.out.println("로그인");
		
		while(true) {
			String id = ScannerUtil.getString("ID : ");
			String pw = ScannerUtil.getString("PW : ");
			
			// DB에서 사용자가 입력한 ID/PW가 일치하는 사용자 정보를 조회
			loginMember = service.login(id, pw);
			
			// 로그인 시 반복문을 탈출
			if(loginMember != null) {
				break;
			}
		}
		
	}
	
	// 사용자 메뉴
	public void userMenu(){
		System.out.println("사용자 메뉴    ============");
		System.out.println("1. 도서 목록 조회");
		System.out.println("2. 사용자 정보수정");
		System.out.println("3. 종료");
		
		
		
	}
	
	// 관리자 메뉴
	public void adminMenu(){
		System.out.println("관리자 메뉴    ============");
		System.out.println("1. 사용자 목록");
		System.out.println("2. 사용자 추가");
		System.out.println("3. 사용자 삭제");
		System.out.println("4. 종료");
		
		String menu = ScannerUtil.getString("메뉴 : ");
		
		switch (menu) {
		case "1" : 
			service.getList();
			break;
		case "2" :
			String id = ScannerUtil.getString("id : ");
			String pw = ScannerUtil.getString("pw : ");
			String name = ScannerUtil.getString("이름 : ");
			String adminYN = ScannerUtil.getString("관리자(Y/N) : ");
			boolean isAdmin = "Y".equals(adminYN);
			
			MemberVO member = new MemberVO(id, pw, name, isAdmin, adminYN);
			service.insert(member);
			break;
		case "3" :
			System.out.println("삭제");
			break;
		case "4" : 
			System.exit(0);
			break;
		default:
			System.out.println("메뉴를 확인후 다시 입력 해주세요");
		}
		
	}
	
	
	
	
}
