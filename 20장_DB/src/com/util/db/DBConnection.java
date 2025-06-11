package com.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vo.EmpVO;

public class DBConnection {
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}  catch (ClassNotFoundException e) {
			System.out.println("라이브러리를 확인해주세요!");
			e.printStackTrace();
		} 
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test1", "1234");
				PreparedStatement pstmt = conn.prepareStatement("select * from emp");
				ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()) {
				EmpVO emp = new EmpVO();
			
				String name = rs.getString("emp_name");
				String ssn = rs.getString("emp_no");
				System.out.println(name + "/" + ssn);
			}
			System.out.println("connection 성공");
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
