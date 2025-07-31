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
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		SearchDto searchDto = new SearchDto(1, 10, "id", "205");
		List<BoardDto> list = dao.getList(searchDto);
		System.out.println("list : " + list);
	}
	
	public List<BoardDto> getList(SearchDto searchDto) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		String where = "";
		// 필터링을 위한 조건문
		if(searchDto.getSearchField() != null && searchDto.getSearchWord() != null) {
			//where = "and " + searchDto.getSearchField() + " like '%" + searchDto.getSearchWord() + "%' ";
			
			// /로 끊어서 문자 배열을 반환
			String[] searchFieldArr = searchDto.getSearchField().split("/");
			for(int i=0;i<searchFieldArr.length;i++) {
				where += searchFieldArr[i] + " like '%" + searchDto.getSearchWord() + "%' ";
				if(i != searchFieldArr.length-1) {
					// 마지막요소에는 or 를 붙이고 싶지 않음
					where += " or ";
				}
			}
			
			where = "and (" + where + ")";
			
			System.out.println("where : " + where);
		}
		
		// 실행할 쿼리
		// 페이징, 검색
		String sql = "SELECT num, title, id, visitcount,\r\n"
					+ "        decode(to_char(postdate, 'yyyy-mm-dd'), to_char(sysdate,'yyyy-mm-dd')\r\n"
					+ "                    , to_char(postdate,'hh24:mi:ss'),  to_char(postdate, 'yyyy-mm-dd')) postdate  "
					+ "	FROM board "
					// 조건절
					+ " where 1=1 "
					+ where
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
				//String content = rs.getString("content");
				String id = rs.getString("id");
				String postdate = rs.getString("postdate");
				int visitcount = rs.getInt("visitcount");
				
				BoardDto board = new BoardDto(num, title, "", id, postdate, visitcount);
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

	/**
	 * 검색필드, 검색어를 파라메터로 전달 받아 조건절을 생성 
	 * 필터링된(= 조회조건) 대상을 기준으로 건수를 조회
	 * @param searchDto
	 * @return
	 */
	public int getTotalCnt(SearchDto searchDto) {
		String where = "";
		// 필터링을 위한 조건문
		if(searchDto.getSearchField() != null && searchDto.getSearchWord() != null) {
			//where = "and " + searchDto.getSearchField() + " like '%" + searchDto.getSearchWord() + "%' ";
			
			// /로 끊어서 문자 배열을 반환
			String[] searchFieldArr = searchDto.getSearchField().split("/");
			for(int i=0;i<searchFieldArr.length;i++) {
				where += searchFieldArr[i] + " like '%" + searchDto.getSearchWord() + "%' ";
				if(i != searchFieldArr.length-1) {
					// 마지막요소에는 or 를 붙이고 싶지 않음
					where += " or ";
				}
			}
			
			where = "and (" + where + ")";
			
			System.out.println("where : " + where);
		}
		
		String sql = "select count(*) from board where 1=1 " + where;
		
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
