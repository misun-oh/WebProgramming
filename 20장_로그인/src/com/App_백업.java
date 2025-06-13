package com;

import com.lib.AllInOne;
import com.vo.MemberVO;

public class App_백업 {
	public static void main(String[] args) {
		System.out.println("==========");
		System.out.println("   성남 아트리움 도서관에 오신걸 환영 합니다.");
		System.out.println("==========");
		AllInOne allInOne = new AllInOne();
		while(true) {
			MemberVO member = allInOne.login();
			
			if(member == null) {
				System.out.println("아이디 비밀번호를 확인 해주세요.");
			} else {
				System.out.println(member.getName() + "님 환영 합니다.");
				if(member.isAdminYN()) {
					System.out.println("관리자 메뉴로 이동 합니다.");
				}
			}
		}
		
	}
}
