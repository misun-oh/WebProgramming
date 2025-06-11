package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionTest_Delete {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "test1";
		String pw = "1234";
		
		
		
		// emp_id는 기본키(pk) 이므로 중복될수 없습니다.
		String sql = "DELETE EMP WHERE EMP_ID IN (200)";
		
		
		
		try {
			Connection con = DriverManager.getConnection(url, id, pw);
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// 입력, 수정, 삭제는 반환 타입을 숫자로 받는다
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				System.out.println(res + "건 삭제");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
