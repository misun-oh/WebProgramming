package com.maven.ex.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maven.ex.spring.service.NotificationService;

public class NotificationServiceTest {
	
	@Test
	public void test() {
		// 설정파일을 읽고 IOC컨테이너에 객체를 생성 
		ApplicationContext ctx 
				= new ClassPathXmlApplicationContext("/com/maven/ex/spring/config/XmlConfig.xml");

		// 컨테이너로 부터 Bean을 꺼내오기		
		NotificationService service = (NotificationService) ctx.getBean("NotificationService");
		service.send("momo.gmail.com", "메세지 전송");
		
	}
}
