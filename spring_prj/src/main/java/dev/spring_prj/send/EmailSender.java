package dev.spring_prj.send;

import org.springframework.stereotype.Component;

// Bean으로 등록
@Component
public class EmailSender implements Sender {
	public EmailSender(){
		System.out.println("기본 생성자 호출");
	}
	
	public void send(String to, String message) {
		System.out.println("email 전송");
		System.out.println("to : " + to);
		System.out.println("msg : " + message);	
	}
}
