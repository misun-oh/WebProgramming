package com.maven.ex.spring.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = "com.maven.ex.spring.mapper")
public class MyBatisConfig {
  
  @Bean
  public HikariDataSource hikariDataSource() {
	  HikariDataSource ds = new HikariDataSource(hikariConfig());
	  return ds;
  }
  
  @Bean
  public HikariConfig hikariConfig() {
	  HikariConfig config = new HikariConfig("/config/hikari.properties");
	  return config;
  }
  
  @Bean
  public SqlSessionFactory sqlSessionFactory(HikariDataSource dataSource) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    //factoryBean.setDataSource(hikariDataSource());
    return factoryBean.getObject();
    
  }
  
}