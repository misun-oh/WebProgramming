package dev.spring_prj.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.spring_prj.send.Sender;

public class NotificationServiceTest {

	@Test
	public void test() {
		
		// 설정파일을 읽어서 스프링 IOC컨테이너에 Bean을 생성
		// 매개변수 경로의 설정파일을 읽어서 Bean을 생성 
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("XmlConfig.xml");
		
		// 컨테이너에 등록된 Bean을 꺼내서 사용해보기
		// id를 이용해서 꺼내올때는 object타입을 반환 하므로 형변환이 필요
		Sender sender = (Sender)ctx.getBean("sender");
		sender.send("emailSender", "이메일 전송");
		
		// 같은 타입의 객체가 존재 하는경우 오류가 발생
		//Sender sender1 = ctx.getBean(dev.spring_prj.send.Sender.class);
		
		// type을 이용해서 꺼내오기
		NotificationService service = ctx.getBean(NotificationService.class);
		service.send("service", "서비스를 이용하여 이메일 전송");
		
	}
}
