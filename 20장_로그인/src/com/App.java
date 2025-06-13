package com;

import com.lib.AllInOne;

public class App {
	public static void main(String[] args) {
		System.out.println("==========");
		System.out.println("   성남 아트리움 도서관에 오신걸 환영 합니다.");
		System.out.println("==========");
		AllInOne allInOne = new AllInOne();
		allInOne.login();
	}
}
