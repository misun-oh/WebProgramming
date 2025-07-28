package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.board.dto.BoardDto;
import com.board.dto.PageDto;
import com.board.dto.SearchDto;
import com.board.service.BoardService;

@WebServlet("/board/list.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	BoardService service = new BoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageNo = request.getParameter("pageNo");
		String amount = request.getParameter("amount");
		
		// 1. 페이징 처리및 검색조건의 수집
		SearchDto searchDto = new SearchDto(pageNo, amount);
		// 2. 목록을 조회
		List<BoardDto> list = service.getList(searchDto);
		int totalCnt = service.getTotalCnt();
		// 3. page블럭을 출력하기위해 pageDto객체 생성
		PageDto pageDto = new PageDto(searchDto, totalCnt);
		
		// 4. 내장객체의 영역에 데이터를 저장
		request.setAttribute("list", list);
		request.setAttribute("pageDto", pageDto);
		
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
