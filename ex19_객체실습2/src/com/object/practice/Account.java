package com.object.practice;

public class Account {
	private int balance;
	
	// 상수정의 : static final
	// 변수명은 모두 대문자로, 연결되는 단어는 _로 연결!!
	// 상수는 선언과 동시에 초기화
	// 한번 값이 정해지면 변경이 불가능 하기 때문에 선언과 동시에 초기화
	private static final int MIN_BALANCE = 0;
	private static final int MAX_BALANCE = 1000000;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		// 생성자에서만 생성자를 호출 할 수 있다!!!!
		// this();
		// 두개의 조건을 충족할때만 필드의 값을 변경
		if(balance > MIN_BALANCE && balance < MAX_BALANCE) {
			// 인스턴스 멤버 접근 this
			this.balance = balance;
		} else {
			System.out.println("입력범위 : " + MIN_BALANCE + "~" + MAX_BALANCE);
			System.out.println("입력 범위를 확인해주세요("+balance+")");
			
		}
	}
	
	public String info() {
		return "현재잔고 : " + balance;
	}
	
	
	
	
	
	
	
	
	
	
	
}
