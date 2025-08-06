package dev.spring_prj.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.spring_prj.send.EmailSender;
import dev.spring_prj.send.Sender;

public class Spring_bean_test {
	
	// xml파일을 읽고 IOC 컨테이너에 Bean객체를 생성
	ApplicationContext ctx 
		= new ClassPathXmlApplicationContext("context_config.xml");
	
	@Test
	public void bean_test() {
		
		// IOC컨테이너로 부터 Bean객체를 꺼내서 사용 해보기
		// ID로 참조시 형변환이 필요
		Sender sender = (Sender)ctx.getBean("sender");
		sender.send("momo@gmail.com", "id로 객체를 꺼낼수 있어!");

		// 객체의 Type을 이용하여 Bean객체를 꺼내오는 방법
		Sender sender2 = ctx.getBean(EmailSender.class);
		sender2.send("momo@gmail.com", "type으로 객체를 꺼낼수 있어!");
	}
	
	@Test
	public void bean_test1() {
		NotificationService service = ctx.getBean(NotificationService.class);
		service.send("a@b.c", "notification 서비스 테스트");
	}
}
