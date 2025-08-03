package com.maven.ex.service;


import com.maven.ex.send.Sender;

public class NotificationService_field {
	// field 주입은 리플렉션을 이용
	private Sender sender;
	public NotificationService_field(){
		
	}
	public NotificationService_field(String str){
		
	}
	public void send(String to, String message) {
	    sender.send(to, message);
	}
 
}