package com.maven.ex.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.maven.ex.spring.service.NotificationService;

public class App_java_config {
    public static void main(String[] args) {
    	
		// 설정파일을 읽고 IOC컨테이너에 Bean을 생성 
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.maven.ex.spring.config.AppConfig.class);
        
        // 컨테이너로 부터 Bean 꺼내오기
        // id로 꺼내기
        NotificationService service = (NotificationService)ctx.getBean("notificationService");
        service.send("momo@gmail.com", "안녕하세요!");
        // Type으로 꺼내기
        NotificationService service1 = ctx.getBean(NotificationService.class);
        service1.send("momo@gmail.com", "안녕하세요!");   
    }
}
