package dev.spring.board.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
// mapper인터페이스의 패키지 위치
@MapperScan(basePackages = "dev.spring.board.mapper")
@ComponentScan(basePackages = "dev.spring.board.service")
@PropertySource("classpath:application.properties")
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

        // === MyBatis 전역 설정 ===
	    org.apache.ibatis.session.Configuration conf = new org.apache.ibatis.session.Configuration();
        conf.setJdbcTypeForNull(JdbcType.NULL);      // ★ 핵심: null 파라미터의 기본 JDBC 타입을 NULL로
        conf.setMapUnderscoreToCamelCase(true);      // 선택
        factoryBean.setConfiguration(conf);
        
	    factoryBean.setDataSource(ds);
	    return factoryBean.getObject();
	}

	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	/*
	 * Spring에서 ${...} 형태의 플레이스홀더를 실제 프로퍼티 값으로 치환해주는 설정 빈
	 * @Value("${file.upload.root}")
	*/ 
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
}
