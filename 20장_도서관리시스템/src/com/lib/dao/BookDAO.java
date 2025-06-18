package com.lib.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.util.ConnectionUtil;
import com.lib.vo.BookVO;

public class BookDAO {
	/*
	getList pstmt.executeQuery() : 결과집합 (ResultSet)
	get
	DML문장은 pstmt.executeUpdate() : 몇건이 처리되었는지 반환 (int)
	insert
	update
	delete
	*/
	
	/**
	 * 상세보기
	 * 한권의 도서 정보를 조회 하여 반환
	 * @param book_no
	 * @return 
	 */
	public BookVO get(String book_no) {
		BookVO book = null;
		String sql = "select *  "
					+ "from book b, category c, publisher p "
					+ "where   b.category_code = c.category_code "
					+ "and     b.PUBLISHER_CODE = p.PUBLISHER_CODE "
					+ "and     book_no=?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			pstmt.setString(1, book_no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String publisher_code = rs.getString(2);
				String category_code = rs.getString(3);
				String title = rs.getString(4);
				String subtitle = rs.getString(5);
				String author = rs.getString(6);
				int publisherYear = rs.getInt(7);
				String url = rs.getString(8);
				String info = rs.getString(9);
				String main_category = rs.getString("main_category");
				String publisher = rs.getString("publisher");
				
				// 결과집합에 조회된 행의 갯수 만큼 bookVO를 만들고 list에 담아준다
				book = new BookVO(book_no, publisher_code, category_code, title, subtitle, author, publisherYear, url, info, main_category, publisher);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
	}
	
	public int delete(String book_no){
		int res = 0;
		String sql = "delete book where book_no = ?";
	
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			pstmt.setString(1, book_no);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 도서목록 조회
	 * @return 도서목록
	 */
	public List<BookVO> getList(){
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "select book_no, b.publisher_code, b.category_code, title, author"
					+ "        , main_category, publisher"
					+ " from book b, category c, publisher p"
					+ " where b.category_code = c.category_code"
					+ " and   b.publisher_code = p.publisher_code";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()) {
				String book_no = rs.getString(1);
				String publisher_code = rs.getString(2);
				String category_code = rs.getString(3);
				String title = rs.getString(4);
				String author = rs.getString(5);
				String main_category = rs.getString(6);
				String publisher = rs.getString(7);
				
				// 결과집합에 조회된 행의 갯수 만큼 bookVO를 만들고 list에 담아준다
				BookVO book = new BookVO(book_no, publisher_code, category_code, title, author, main_category, publisher);
				
				list.add(book);
				
			}
			//if (!rs.isClosed()) rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 도서를 추가 하고 결과를 반환 합니다.
	 * @param book
	 * @return
	 */
	public int insert(BookVO book) {
		int res = 0;
		String sql = "insert into book (BOOK_NO, PUBLISHER_CODE, CATEGORY_CODE, TITLE, SUB_TITLE "
				+ "                    , AUTHOR, PUBLISHED_YEAR, URL, INFO) "
				+ "            values ('B'||lpad(seq_book.nextval,5,0), ?, ?, ?, ? "
				+ "                    , ?, ?, ?, ?)";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			// ? 의 갯수와 순서에 맞게 입력
			pstmt.setString(1, book.getPublisher_code());
			pstmt.setString(2, book.getCategory_code());
			pstmt.setString(3, book.getTitle());
			pstmt.setString(4, book.getSub_title());
			pstmt.setString(5, book.getAuthor());
			pstmt.setInt(6, book.getPublished_year());
			pstmt.setString(7, book.getUrl());
			pstmt.setString(8, book.getInfo());
			
			res = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		
		BookVO book = dao.get("B00111");
		// 상세조회 = 한권의 도서 정보를 조회
		System.out.printf("%s \t %s \t %s %s \t \n"
				, book.getBook_no(), book.getTitle(), book.getMain_category(), book.getPublisher());
		
		// 도서 삭제
		/*
		int res = dao.delete("B00646");
		System.out.println(res + "건 처리되었습니다.");
		*/
		
		// 도서 추가
		/*
		BookVO book = new BookVO("", "P001", "C01", "JDBC_신규도서", "오라클 연동 해보기", "오미자", 2025
									, "url", "info", null, null);
		int res = dao.insert(book);
		System.out.println(res + "건 처리 되었습니다.");
		*/
		
		// 도서 목록 조회
		/*
		List<BookVO> list = dao.getList();
		System.out.println("도서목록 조회");
		for(BookVO book:list) {
			System.out.printf("%s \t %s \t %s %s \t \n"
					, book.getBook_no(), book.getTitle(), book.getMain_category(), book.getPublisher());
			//System.out.println(book);
		}
		*/
	}
}
