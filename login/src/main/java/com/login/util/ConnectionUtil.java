package com.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "test1";
	private static final String PW = "1234";
	
	// 데이터 베이스에 접근할 수 있는 Connection 객체를 생성하고 반환 한다 
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("라이브러리 로딩 성공!");
			// 쿼리를 질의 하기 위해 Connection 객체를 생성
			con = DriverManager.getConnection(URL, ID, PW);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
