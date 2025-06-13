package com;

import com.lib.controller.LibraryController;

// 실행
public class App {
	
	public static void main(String[] args) {
		// 도서관 
		LibraryController lib = new LibraryController();
		// 로그인
		lib.login();
		
		if(lib.loginMember.isAdminYN()) {
			// 관리자
			lib.adminMenu();
		} else {
			// 사용자
			lib.userMenu();
		}
		
	}
}
