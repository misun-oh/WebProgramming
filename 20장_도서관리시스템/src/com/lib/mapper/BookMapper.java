package com.lib.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.lib.vo.BookVO;

public interface BookMapper {
	@Select("SELECT * FROM Book ")
	List<BookVO> selectBlog(int id);
	
	List<BookVO> selectBookList();
	
	//@Select("SELECT * FROM Book WHERE BOOK_NO=#{ID}")
	BookVO selectBook(String id);
	
	int selectBookCnt();
}
