package com.maven.ex.send;

public class EmailSender implements Sender{
	
	public void send(String to, String message) {
		System.out.println("email 전송");
		System.out.println("to : " + to);
		System.out.println("msg : " + message);	
	}
}
