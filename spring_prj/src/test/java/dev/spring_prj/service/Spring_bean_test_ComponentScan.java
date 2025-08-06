package dev.spring_prj.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.spring_prj.config.ContextCompontScan;
import dev.spring_prj.send.EmailSender;

public class Spring_bean_test_ComponentScan {

	@Test
	public void test() {
		ApplicationContext ctx 
			= new AnnotationConfigApplicationContext(ContextCompontScan.class);
		
		EmailSender sender = ctx.getBean(EmailSender.class);
		sender.send("a@b.c", "component scan으로 Bean을 등록 해봅시다!");
		
		
		NotificationService service = ctx.getBean(NotificationService.class);
		service.send("momo@gmail.c", "component scan");
		
	}
}
