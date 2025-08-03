package com.maven.ex.spring.mapper;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.maven.ex.spring.config.MyBatisConfig;
import com.maven.ex.spring.dto.BoardDto;
import com.zaxxer.hikari.HikariDataSource;

@SpringJUnitConfig(MyBatisConfig.class)
public class HikariCP_Mybatis_test {
	
	@Autowired
	HikariDataSource ds;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void test() throws SQLException {
		System.out.println(ds.getConnection());
		System.out.println(sqlSessionFactory);
		System.out.println(mapper);
		System.out.println(mapper.getList());
	}
	
	@Test
	public void get() {
		BoardDto board = mapper.get();
		System.out.println(board.getTitle());
	}
}
