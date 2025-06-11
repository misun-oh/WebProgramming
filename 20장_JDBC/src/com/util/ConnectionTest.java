package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("ojdbc 라이브러리 로딩 성공!");
			
			// DB에 접근하여 Connection객체를 반환
			// 데이터 베이스에 접근 하기 위해서 필요한 정보 5가지
			// ip, port, sid, userid, userpw
			Connection con = DriverManager.getConnection(
														"jdbc:oracle:thin:@localhost:1521:xe"
														, "test1"
														, "1234");
			System.out.println(con);
			
			// 쿼리를 질의 하기 위한 객체를 생성
			Statement stmt = con.createStatement();
			// 쿼리를 실행 하고 결과를 받아 온다
			// ; 세미콜론은 제거 합니다. <-- ERR
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");
			
			while(rs.next()) {
				int emp_id = rs.getInt(1);
				String emp_name = rs.getString("emp_name");
				System.out.println("emp_id : " + emp_id + ", emp_name : " + emp_name);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ojdbc 라이브러리를 확인해주세요");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
