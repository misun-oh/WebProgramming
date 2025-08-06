package dev.spring_prj.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import dev.spring_prj.send.EmailSender;
import dev.spring_prj.send.Sender;
import dev.spring_prj.service.NotificationService;

@Configuration
// mapper인터페이스의 패키지 위치
@MapperScan(basePackages = "dev.spring_prj.mapper")
public class AppConfig {

	// HikariConfig config = new HikariConfig("hikari.properties");
	@Bean("hikariConfig")
	public HikariConfig hikariConfig() {
		return new HikariConfig("hikari.properties");
	}
	
	// HikariDataSource ds = new HikariDataSource(config);
	@Bean("hikariDataSource")
	public HikariDataSource hikariDataSource(HikariConfig hikariConfig) {
		return new HikariDataSource(hikariConfig);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(HikariDataSource ds) throws Exception {
	    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	    factoryBean.setDataSource(ds);
	    return factoryBean.getObject();
	}
	  
	@Bean("sender")
	public Sender sender() {
		return new EmailSender();
	}
	
	@Bean("notificationService")
	public NotificationService notificationService(Sender sender) {
		return new NotificationService(sender);
	}
	
}
