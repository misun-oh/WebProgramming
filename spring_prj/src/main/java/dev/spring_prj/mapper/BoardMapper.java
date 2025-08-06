package dev.spring_prj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dev.spring_prj.dto.BoardDto;
import dev.spring_prj.dto.SearchDto;

public interface BoardMapper {

	@Select("select * from board ORDER BY num DESC OFFSET (#{arg0}-1)*#{arg1} ROWS FETCH NEXT #{arg0} ROWS ONLY ")
	List<BoardDto> getList(int pageNo, int amount);
	
	@Select("select * from board ORDER BY num DESC OFFSET (#{pageNo}-1)*#{amount} ROWS FETCH NEXT #{amount} ROWS ONLY ")
	List<BoardDto> getList1(@Param("pageNo") int pageNo, @Param("amount") int amount);
	
    List<BoardDto> searchBoard(SearchDto dto);

	List<BoardDto> getPagedList(SearchDto search);
	
	//@Select("select * from board where num=#{num}")
	BoardDto get(int num);
	
}
