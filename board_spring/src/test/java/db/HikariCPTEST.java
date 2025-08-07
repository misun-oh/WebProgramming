package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPTEST {
	
	@Test
    void connectTest() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        long start = System.currentTimeMillis();
        for(int i=0;i<100;i++) {
        	try (Connection conn = DriverManager.getConnection(
        			"jdbc:oracle:thin:@localhost:1521:xe", "board", "1234");
        			) {
        		System.out.println(conn);
        	}        	
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start + "ms");
    }
	
	@Test
	public void hikariTest() throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		config.setUsername("board");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource ds = new HikariDataSource(config);
		long start = System.currentTimeMillis();
        for(int i=0;i<100;i++) {
			try(Connection con = ds.getConnection()){
				System.out.println(con);
			}
        }
        
        long end = System.currentTimeMillis();
        System.out.println(end-start + "ms");
	}
	
	@Test
	public void hikari_properties() {
		// HikariConfig
		HikariConfig config = new HikariConfig("hikari.properties");
		// HikariDataSource
		HikariDataSource ds = new HikariDataSource(config);
		
		System.out.println("최대 커넥션 수 (max): " + ds.getMaximumPoolSize());
		System.out.println("유휴 커넥션 수 (minIdle): " + ds.getMinimumIdle());
		
	}
}
