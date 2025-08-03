package com.maven.ex.service;


import com.maven.ex.send.Sender;
public class NotificationService {
	 private final Sender sender;

	/*
	 * 생성자 주입 DI
	 * 생성자를 이용하여 외부로 부터 의존관계에 있는 객체를 주입 받아서 사용
	 * 
	 * 1. 필수 의존성
	 * 		객체 생성 시 반드시 생성자를 호출해야 하므로, 의존성을 빼먹을 수 없음
	 * 2. 불변성 보장
	 * 		의존 객체를 생성자에서 한 번 주입받으면, 이후 바뀌지 않음 
	 *		→ 객체 상태가 안정됨 필드 주입처럼 중간에 값이 변경될 위험이 없음
	 */
	public NotificationService (Sender sender) {
	    this.sender = sender;
	}
	 
	public void send(String to, String message) {
	    sender.send(to, message);
	}
 
}