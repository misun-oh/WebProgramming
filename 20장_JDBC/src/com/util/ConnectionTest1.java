package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vo.EmpVO;

public class ConnectionTest1 {
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "test1";
		String pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			Connection con = DriverManager.getConnection(url, id, pw);
			
			String str = "SELECT 	* "
					+ 	 "FROM 		EMP "
					+ 	 "WHERE 	EMP_NAME = ? "
					+ 	 "AND 		EMP_ID = ? ";
			
			// 파라메터 지정 하는 부분이 ?로 변경됨
			PreparedStatement pstmt = con.prepareStatement(str);
			pstmt.setString(1, "오미자");
			pstmt.setInt(2, 200);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + "/" + rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("드라이버 로딩 실피");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("con객체 생성 실패");
		}
	}
}
