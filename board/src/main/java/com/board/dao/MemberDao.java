package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.util.ConnectionUtil;

public class MemberDao {
	
	/**
	 * 사용자의 id, pw를 입력 받아서 일치하는 사용자 정보를 조회 Member객체를 반환
	 * @param id
	 * @param pass
	 */
	public void login(String id, String pass) {
		
		String sql = "select * from member where id=? and pass=?";
		
		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				System.out.println("name : " + name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		dao.login("musthave", "1234");
	}
}
