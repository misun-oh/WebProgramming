package dev.spring_prj.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.spring_prj.config.ContextCompontScan;

@SpringJUnitConfig(ContextCompontScan.class)
public class SpringTest {
	// 필드 주입
	@Autowired
	NotificationService service;
	
	// 생성자 주입 
	// 외부로(IOC컨테이너) 부터 객체를 주입
	public SpringTest(NotificationService service){
		this.service = service;
	}
	
	@Test
	public void test() {
		service.send("momo@gmail.com", "스프링 테스트");
	}
	
	
}
