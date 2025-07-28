package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDto;
import com.board.dto.MemberDto;
import com.board.dto.SearchDto;
import com.board.util.ConnectionUtil;

public class BoardDao {

	public List<BoardDto> getList(SearchDto searchDto) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		// 실행할 쿼리
		// 페이징, 검색
		String sql = "SELECT  * "
					+ "	FROM board "
					+ "ORDER BY num desc "
					+ "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		
		ResultSet rs = null;
		// 데이터 베이스에 접근에서 멤버객체를 생성하고 리스트에 담기
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			
			// ? 파라메터 세팅
			pstmt.setInt(1, (searchDto.getPageNo()-1) * searchDto.getAmount());
			pstmt.setInt(2, searchDto.getAmount());
			rs = pstmt.executeQuery(); // 쿼리의 실행 결과 결과집합에 접근할수 있는 객체

			while(rs.next()) {
				// 행을 읽어와서 MemberDto객체를 생성 
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String postdate = rs.getString("postdate");
				int visitcount = rs.getInt("visitcount");
				
				BoardDto board = new BoardDto(num, title, content, id, postdate, visitcount);
				// 리스트에 MemberDto 객체를 추가
				list.add(board);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int getTotalCnt() {
		String sql = "select count(*) from board";
		
		ResultSet rs = null;
		int totalCnt = 0;
		// 데이터 베이스에 접근에서 멤버객체를 생성하고 리스트에 담기
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			rs = pstmt.executeQuery(); // 쿼리의 실행 결과 결과집합에 접근할수 있는 객체
			
			if (rs.next()) {
				totalCnt = rs.getInt(1);
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(!rs.isClosed())	rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return totalCnt;
	}

}
