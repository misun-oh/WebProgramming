package com.maven.ex.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 스프링 설정파일
@Configuration
@ComponentScan(basePackages = "com.maven.ex.spring")
public class AppConfig {
	
	/*
	// IOC컨테이너에 Bean 객체로 등록
	// @Bean 어노테이션이 설정정보를 읽고 IOC컨테이너에 객체를 생성해줌
    @Bean("sender")
    public Sender sender() {
        return new EmailSender(); // 또는 new SmsSender()
    }

    @Bean("notificationService")
    public NotificationService notificationService(Sender sender) {
        return new NotificationService(sender);
    }
    */
	
}
