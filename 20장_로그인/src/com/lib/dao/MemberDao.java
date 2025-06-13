package com.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.ConnectionUtil;
import com.vo.MemberVO;

public class MemberDao {
	/**
	 * 인증
	 * 데이터베이스에 접근해서
	 * 사용자로 부터 전달 받은 ID,PW에 해당하는 사용자가 있는지 확인
	 * @param 아이디, 비밀번호
	 * @return MemberVO
	 */
	public MemberVO login(String id, String pw) {
		// 데이터 베이스에 조회된 사용자가 있으면 사용자 객체를 만들어서 반환
		// 없으면 null을 반환
		MemberVO member = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=? AND pw=?";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				// 로그인 
				String name = rs.getString("name");
				String adminYN = rs.getString("adminYN");
				boolean isAdminYN = "Y".equals(adminYN);
				member = new MemberVO(id, pw, name, isAdminYN);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리실행중 오류 발생");
		}
		
		return member;
	}
}
