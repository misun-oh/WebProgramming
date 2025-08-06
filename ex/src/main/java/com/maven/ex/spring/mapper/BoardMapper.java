package com.maven.ex.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.maven.ex.spring.dto.BoardDto;


public interface BoardMapper {
	@Select("select * from board")
	public List<BoardDto> getList();
	
	public BoardDto get();
}
