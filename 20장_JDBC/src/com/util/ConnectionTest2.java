package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vo.EmpVO;

public class ConnectionTest2 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "test1";
		String pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			Connection con = DriverManager.getConnection(url, id, pw);
			String sql = "SELECT * FROM EMP";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			// 리스트를 생성
			List<EmpVO> list = new ArrayList<EmpVO>();
			while(rs.next()) {
				String empName = rs.getString(1);
				String empId = rs.getString(2);
				// 사원을 생성 해서 리스트에 담기
				EmpVO emp = new EmpVO();
				emp.setEmp_id(empId);
				emp.setEmp_name(empName);
				list.add(emp);
			}
			
			for(EmpVO emp:list) {
				System.out.println(emp);
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		}
	}
}
