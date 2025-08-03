package com.maven.ex.spring.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class HikariCPTest {
	
	@Test()
	@Description("ojdbc")
	public void ojdbcTest() throws SQLException{
		
		long start = System.currentTimeMillis();
		for(int i=0;i<100;i++) {
			try (Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "library", "1234");) {
				System.out.println(i + "/" + conn);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start+"ms");
		
	}
	
	@Test()
	@Description("hikariCP")
	public void hikariTest() throws SQLException{
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		config.setUsername("library");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource ds = new HikariDataSource(config);
		
		System.out.println(ds);
		long start = System.currentTimeMillis();
		for(int i=0;i<100;i++) {
			try(Connection conn = ds.getConnection();){
				System.out.println(i + "/" + conn);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start+"ms");
		
	}
	
	@Test()
	@Description("hikariCP - 설정파일")
	public void hikariTest_properties() throws SQLException{
		
		HikariConfig config = new HikariConfig("/config/hikari.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		System.out.println("최대 커넥션 수 (max): " + ds.getMaximumPoolSize());
		System.out.println("유휴 커넥션 수 (minIdle): " + ds.getMinimumIdle());
		
	}
}
