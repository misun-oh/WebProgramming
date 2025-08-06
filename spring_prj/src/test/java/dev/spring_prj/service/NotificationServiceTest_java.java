package dev.spring_prj.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.spring_prj.config.AppConfig;
import dev.spring_prj.send.Sender;

public class NotificationServiceTest_java {

	@Test
	public void test() {
		// java 설정파일을 읽어서 IOC컨테이너에 Bean객체를 등록
		ApplicationContext ctx 
			= new AnnotationConfigApplicationContext(AppConfig.class);
		
		Sender sender = ctx.getBean(Sender.class);
		
		
		NotificationService service = ctx.getBean(NotificationService.class);
		service.send("momo@gmail.com", "java 설정파일을 이용하여 SpringContainer 생성 하기");
		
	}
}
