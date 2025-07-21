package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.login.dto.MemberDto;
import com.login.util.ConnectionUtil;

public class MemberDao {

	/**
	 * 사용자 id, pw를 전달 받아 일치하는 사용자 정보를 조회
	 * 조회된 사용자가 있다면 MemberDto객체를 생성후 반환
	 * 				없다면 null을 반환
	 */
	public MemberDto login(int id, String pw) {
		// ✨ 질의할 쿼리
		String sql = "select * from member where id=? and pw=?";
		MemberDto member = null;
		
		ResultSet rs = null;
		// try(생성)시 자원을 자동으로 반납
		try (Connection con = ConnectionUtil.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);){
			
			// ✨ 파라메터 세팅
			pstmt.setInt(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// ✨ 결과집합을 이용해서 객체를 생성
				// member 객체를 생성후 반환
				String name = rs.getString("name");
				String admin_yn = rs.getString("admin_yn");
				String reg_date = rs.getString("reg_date");
				String grade_code = rs.getString("grade_code");
				String del_yn = rs.getString("del_yn");
				
				member = new MemberDto(id, "", name, admin_yn, reg_date, grade_code, del_yn);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원 반납
			try {
				if(!rs.isClosed()) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return member;
	}
	
	// 테스트
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		String encoded_pw = Base64.getEncoder().encodeToString("1234".getBytes());

		MemberDto member = dao.login(13, encoded_pw);
		
		System.out.println("member : " + member);
	}
}
