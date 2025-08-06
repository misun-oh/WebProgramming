package dev.spring_prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.spring_prj.send.Sender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Service
public class NotificationService {
	
	 private Sender sender;
	 
	 // 생성자 주입
	 @Autowired
	 public NotificationService(Sender sender){
		 System.out.println("매개변수 있는 생성자 호출");
		 System.out.println(sender + " / 외부로 부터 주입 받음");
		 // 생성자를 통해 주입 받은 객체를 필드에 세팅	
		this.sender = sender;
	 }
	 
	 public void send(String to, String message) {
	     sender.send(to, message);
	 }
}
