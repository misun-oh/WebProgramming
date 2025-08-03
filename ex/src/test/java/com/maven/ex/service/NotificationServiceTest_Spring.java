package com.maven.ex.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.maven.ex.spring.service.NotificationService;

/*
 *  설정파일 읽어 IOC컨테이너에 Bean객체 생성
 *  @SpringJUnitConfig(AppConfig.class)
 *  	→ @ExtendWith(SpringExtension.class) + @ContextConfiguration을 합친 단축 표현
 */
@SpringJUnitConfig(locations = "/com/maven/ex/spring/config/xmlConfig.xml")
public class NotificationServiceTest_Spring {

	/* DI */
	@Autowired
    NotificationService notificationService;

	/* junit 테스트 목록 */
	@Test
	public void sendTest() {
		notificationService.send("momo", "즐거운 여름 휴가!");
	}
}