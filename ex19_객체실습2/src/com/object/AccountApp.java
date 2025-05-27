package com.object;

import com.object.practice.Account;

public class AccountApp {
	public static void main(String[] args) {
		// 클래스이름을 타입으로 사용
		Account account = new Account();
		account.setBalance(10000);
		System.out.println(account.info());
		
		account.setBalance(-1000);
		System.out.println(account.info());
		
		account.setBalance(10000000);
		System.out.println(account.info());
		
		account.setBalance(300000);
		System.out.println(account.info());
	}
}
