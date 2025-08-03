package com.maven.ex.spring.send;

import org.springframework.stereotype.Component;

@Component
public class EmailSender implements Sender{
	
	public void send(String to, String message) {
		System.out.println("email 전송");
		System.out.println("to : " + to);
		System.out.println("msg : " + message);	
	}
}
