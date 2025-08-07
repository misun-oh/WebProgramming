package db;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.zaxxer.hikari.HikariDataSource;

import dev.spring.board.config.AppConfig;



// hikaricp.properties(설정파일) 읽어서 설정하는 부분이 추가 
// 스프링 설정파일(java)을 읽어서 IOC컨테이너를 준비
@SpringJUnitConfig(AppConfig.class)
public class HikariCPSpringTest {
	@Autowired
	HikariDataSource ds;
	
	@Test
	public void test() throws SQLException {
		System.out.println(ds.getConnection());
	}
}
