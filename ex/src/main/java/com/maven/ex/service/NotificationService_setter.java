package com.maven.ex.service;


import com.maven.ex.send.Sender;

public class NotificationService_setter {
	private Sender sender;

	/*
	 * 객체가 생성된 이후 setter 메서드를 통해 주입  
	 */
	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public void send(String to, String message) {
	    sender.send(to, message);
	}
 
}