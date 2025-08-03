package com.lib.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lib.vo.BookVO;

public interface BookMapper {
	
	// 메서드가 호출 되면 연결된 쿼리문장이 실행 되고 실행 결과가 반환 된다
	// 1. xml파일에 작성된 쿼리를 사용하는경우
	// 		태그의 id속성에 메서드의 이름을 작성
	List<BookVO> selectBookList();
	
	// 메서드 오버로딩(같은 이름으로 작성시) 오류가 발생!!
	//@Select("select * from book where book_no='B00104'")
	//BookVO selectBook();
	
	// 2. 어노테이션을 이용해서 쿼리를 작성
	// ❗어노테이션을 사용하면서 xml에 연결된 경우 오류
	// #{} : 내부적으로 pstmt가 사용
	@Select("select * from book where no=#{bookId}")
	BookVO selectBook(String bookId);
}
