package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.MemberDto;
import com.board.dto.SearchDto;
import com.board.util.ConnectionUtil;

public class MemberDao {
	
	/**
	 * 사용자의 정보를 수집하여 데이터 베이스에 등록
	 * DML(insert, update, delete) 문장의 반환 타입은 int
	 * 	- 몇건이 처리되었는지 처리건수를 반환 
	 * @return
	 */
	public int insert(MemberDto member) {
		int res = 0;
		String sql = "insert into member (id, pass, name, regidate)  "
					+ "    			values (?, ?, ?, sysdate)";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			
			// dml문장의 실행 결과를 변수에 담는다 = 몇건 처리가 되었는지 반환됨
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	/**
	 * 사용자의 id, pw를 입력 받아서 일치하는 사용자 정보를 조회 Member객체를 반환
	 * @param id
	 * @param pass
	 */
	public MemberDto login(String id, String pass) {
		
		String sql = "select * from member where id=? and pass=?";
		// id/pw일치하는 사용자가 있으면 MemberDto반환, 아니면 null 반환
		MemberDto member = null;
		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			// 아이디 비밀번호가 일치하는 사용자가 있다면 Member객체를 생성
			if(rs.next()) {
				String name = rs.getString("name");
				String regidate = rs.getString("regidate");
				System.out.println("name : " + name);
				
				member = new MemberDto(id, pass, name, regidate);
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
		
		return member;
	}
	
	/**
	 * 사용자의 목록을 조회후 반환
	 * @return
	 */
	public List<MemberDto> getMemberList() {
		List<MemberDto> list = new ArrayList<MemberDto>();
		// 실행할 쿼리
		// 페이징, 검색
		String sql = "select * from member";
		
		// 데이터 베이스에 접근에서 멤버객체를 생성하고 리스트에 담기
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery(); // 쿼리의 실행 결과 결과집합에 접근할수 있는 객체
			){
			
			while(rs.next()) {
				// 행을 읽어와서 MemberDto객체를 생성 
				String id = rs.getString("id");
				String name = rs.getString("name");
				String regidate = rs.getString("regidate");
				MemberDto member = new MemberDto(id, "", name, regidate);
				// 리스트에 MemberDto 객체를 추가
				list.add(member);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 사용자의 목록을 조회후 반환
	 * 
	 * 페이징처리
	 * 	- searchDto를 매개변수로 받아오기
	 *  - 쿼리를 페이징 처리가된 쿼리로 수정하기
	 * @return
	 */
	public List<MemberDto> getMemberListPageing(SearchDto searchDto) {
		List<MemberDto> list = new ArrayList<MemberDto>();
		String where = searchDto.getWhere();
		
		// 실행할 쿼리
		// 페이징, 검색
		String sql = "SELECT  * "
					+ "	FROM member "
					// 필터링 조건을 조건절 추가
					+ "WHERE 1=1 "
					+ where 
					+ "ORDER BY regidate desc "
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
				String id = rs.getString("id");
				String name = rs.getString("name");
				String regidate = rs.getString("regidate");
				MemberDto member = new MemberDto(id, "", name, regidate);
				// 리스트에 MemberDto 객체를 추가
				list.add(member);
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
	
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		int totalCnt = dao.getTotalCnt(new SearchDto());
		System.out.println("총건수 : " + totalCnt);
		
		/*
		// 1 ~ 10
		//SearchDto dto = new SearchDto();
		// 11 ~ 20
		// new SearchDto(페이지번호,페이지당게시물수,"","");
		SearchDto dto = new SearchDto(2,10,"","");
		List<MemberDto> list = dao.getMemberListPageing(dto);
		System.out.println(list);
		System.out.println("size" + list.size());
		*/
		
		/*
		MemberDto member = new MemberDto("1", "1234567", "", "");
		int res = dao.updateMember(member);
		System.out.println(res+"건 처리 되었습니다.");
		*/
		
		/*
		int res = dao.deleteMember("201");
		System.out.println(res);
		*/
		
		/*
		// 사용자 조회
		MemberDto member = dao.getMember("201");
		System.out.println(member);
		*/
		
		/*
		// 사용자 등록
		MemberDto member = new MemberDto("id", "pass", "name" ,"");
		int res = dao.insert(member);
		System.out.println(res + "건 처리 되었습니다.");
		*/
		
		/*
		// 로그인
		MemberDto member = dao.login("musthave", "1234");
		System.out.println("로그인 사용자 정보");
		System.out.println(member);
		*/
		
		/*
		// 멤버 목록 조회
		List<MemberDto> list = dao.getMemberList();
		for(MemberDto member:list) {
			System.out.println(member);			
		}
		*/
	}

	public boolean idCheck(String id) {
		String sql = "select * from member where id = ?";
		
		ResultSet rs = null;
		// 데이터 베이스에 접근에서 멤버객체를 생성하고 리스트에 담기
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // 쿼리의 실행 결과 결과집합에 접근할수 있는 객체
			
			if (rs.next()) {
				return false;
			} else {
				return true;
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
		
		return false;
	}

	/**
	 * 사용자 정보를 조회 후 Member객체를 반환
	 * @param id
	 * @return
	 */
	public MemberDto getMember(String id) {
		MemberDto member = null;
		String sql = "select * from member where id = ?";
		
		ResultSet rs = null;
		// 데이터 베이스에 접근에서 멤버객체를 생성하고 리스트에 담기
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // 쿼리의 실행 결과 결과집합에 접근할수 있는 객체
			
			if (rs.next()) {
				// 행을 읽어와서 MemberDto객체를 생성
				String name = rs.getString("name");
				String regidate = rs.getString("regidate");
				
				// member객체를 생성
				member = new MemberDto(id, "", name, regidate);
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
		
		return member;
		
	}

	public int deleteMember(String id) {
		int res = 0;
		String sql = "delete member where id = ?";
		System.out.println(sql+"========"+id);
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, id);
			
			// dml문장의 실행 결과를 변수에 담는다 = 몇건 처리가 되었는지 반환됨
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public int updateMember(MemberDto member) {
		int res = 0;
		String sql = "update member set pass = ? where id = ?";
		System.out.println("updateMember()    ========  " + member);
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, member.getPass());
			pstmt.setString(2, member.getId());
			
			// dml문장의 실행 결과를 변수에 담는다 = 몇건 처리가 되었는지 반환됨
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public int getTotalCnt(SearchDto dto) {
		String where = dto.getWhere();
		String sql = "select count(*) from member where 1=1 " + where;
		
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
