package com.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.ConnectionUtil;
import com.util.ScannerUtil;
import com.vo.MemberVO;

public class AllInOne {
	
	/**
	 * 인증(Authentication)
	 * 사용자로 부터 ID, PW를 입력 받아서 사용자가 있는지 확인하는 작업
	 */
	public MemberVO login() {
		MemberVO loginMember = null;		
		System.out.println("로그인");
		
		// 사용자로부터 id, pw를 입력 받아서 변수에 저장
		String id = ScannerUtil.getString("id : ");
		String pw = ScannerUtil.getString("pw : ");
	
		try {
			
			// 쿼리를 질의 하기 위해 Connection 객체를 생성
			Connection con = ConnectionUtil.getConnection();
			String sql = "select * from member where id=? and pw=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?의 갯수 만큼 세팅 해야한다!!!
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			// 쿼리를 실행하고 결과집합를 받아온다
			ResultSet rs = pstmt.executeQuery();
			
			// 질의 결과가 단일행이므로 반복(while)문을 사용할 필요가 없다 
			if(rs.next()) {
				// if문 안에 들어 왔다는것은 
				// 사용자가 입력한 id, pw에 일치하는 사용자가 있다는 것이다!!!
				// memberVO만들어 봅시다
				String name = rs.getString("name");
				// y이면 true, 아니면 false
				boolean isAdminYN = "Y".equals(rs.getString("adminYN"));
				

				loginMember = new MemberVO(id, pw, name, isAdminYN);
			}
			
			// 자원해제(자원반납)
			if(!rs.isClosed()) rs.close();
			if(!pstmt.isClosed()) pstmt.close();
			if(!con.isClosed()) con.close();
			
			
		}  catch (SQLException e) {
			System.err.println("DB 접근 오류 발생!");
			e.printStackTrace();
		} 
		
		return loginMember;

	}
}
