package dev.spring_prj.config;
import dev.spring_prj.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.spring_prj.send.EmailSender;
import dev.spring_prj.send.Sender;

@Configuration
public class ContextConfig {

	@Bean
	public EmailSender sender() {
		return new EmailSender();
	}
	
	// 생성자 주입
	@Bean
	public NotificationService notifacationService(Sender sender) {
		return new NotificationService(sender);
	}
}


