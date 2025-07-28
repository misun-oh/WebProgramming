package com.board.service;

import java.util.List;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.board.dto.SearchDto;

public class BoardService {

	BoardDao dao = new BoardDao();
	
	public List<BoardDto> getList(SearchDto searchDto) {
		return dao.getList(searchDto);
	}

	public int getTotalCnt() {
		return dao.getTotalCnt();
	}

}
