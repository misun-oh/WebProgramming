package com.maven.ex.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.ex.spring.send.Sender;

@Service
public class NotificationService {
	
	private Sender sender;

	@Autowired
	public NotificationService(Sender sender) {
		this.sender = sender;
	}

	public void send(String to, String message) {
	    sender.send(to, message);
	}
}
