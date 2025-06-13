package com.lib;

import java.util.Scanner;

public class AllInOne {
	
	Scanner s = new Scanner(System.in);
	
	/**
	 * 인증(Authentication)
	 * 사용자로 부터 ID, PW를 입력 받아서 사용자가 있는지 확인하는 작업
	 */
	public void login() {
		System.out.println("로그인");
		System.out.print("id : ");
		String id = s.next();
		System.out.print("pw : ");
		String pw = s.next();
		System.out.println("id : " + id + ", pw : " + pw);
		
		

	}
}
