package dev.spring.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dev.spring.board.dto.BoardDto;
import dev.spring.board.dto.SearchDto;



public interface BoardMapper {
	@Select("select * from board where num=#{num}")
	BoardDto get(int num);
	
	// 파라메터가 여러개인 경우 이름을 직접 작성
	@Select("select * from board ORDER BY num DESC "
			+ "    OFFSET (#{pageNo} - 1) * #{amount} ROWS FETCH NEXT #{amount} ROWS ONLY")
	List<BoardDto> getList(@Param("pageNo") int pageNo, @Param("amount") int amount);
	
	// 이름을 붙여주면 이름으로 불러줘야한다 #{search.pageNo}
	List<BoardDto> getPagedList(@Param("search") SearchDto search);
	
	List<BoardDto> getSearchedList(SearchDto search);
}
