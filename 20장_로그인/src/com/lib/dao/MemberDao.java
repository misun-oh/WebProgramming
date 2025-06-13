package com.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.ConnectionUtil;
import com.vo.MemberVO;

/*
 * 😊 select는 pstmt.executeQuery()을 사용
 * 😊 insert, update, delete 는 pstmt.executeUpdate()를 사용
 */
public class MemberDao {
	
	// 입력/수정/삭제 정수 반환 - 몇건이 처리되었는지 반환
	public int insert(MemberVO member) {
		int res = 0;
		String sql = "insert into member values (? ,? ,? ,?)";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAdmin());
			
			res = pstmt.executeUpdate();
			 
			if(!pstmt.isClosed()) pstmt.close(); 
			if(!con.isClosed()) con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리실행중 오류 발생");
		}
		
		return res;
	}
	
	/**
	 * 사용자 목록을 조회 하고 리스트에 담아서 반환 한다
	 * @return 사용자목록
	 */
	public List<MemberVO> getList(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		String sql = "SELECT * FROM MEMBER";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement pstmt =  con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			// rs.next() -> 한 행을 읽어서 MemverVO만든고 리스트에 담는다
			while(rs.next()) {
				// 로그인 
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String adminYN = rs.getString("adminYN");
				boolean isAdminYN = "Y".equals(adminYN);
				MemberVO member = new MemberVO(id, pw, name, isAdminYN, adminYN);
				list.add(member);
			}
			
			if(!rs.isClosed()) rs.close(); 
			if(!pstmt.isClosed()) pstmt.close(); 
			if(!con.isClosed()) con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리실행중 오류 발생");
		}
		return list;
	}
	
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
				member = new MemberVO(id, pw, name, isAdminYN, adminYN);
			}
			
			if(!rs.isClosed()) rs.close(); 
			if(!pstmt.isClosed()) pstmt.close(); 
			if(!con.isClosed()) con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리실행중 오류 발생");
		}
		
		return member;
	}
}
