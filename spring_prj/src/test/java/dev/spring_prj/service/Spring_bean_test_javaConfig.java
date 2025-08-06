package dev.spring_prj.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.spring_prj.config.ContextConfig;

public class Spring_bean_test_javaConfig {
	// java설정파일을 읽어서 컨테이너를 만들고 Bean을 생성
	ApplicationContext ctx 
		= new AnnotationConfigApplicationContext(ContextConfig.class);
	
	@Test
	public void test() {
		NotificationService service= ctx.getBean(NotificationService.class);
		service.send("momo@gmail.com", "java 설정을 이용하여 객체를 생성");
	}
}
