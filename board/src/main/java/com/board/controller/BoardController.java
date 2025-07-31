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

//@WebServlet("/board/list.do")
@WebServlet(urlPatterns = {"/boardAll/*", "/board/list.do"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	BoardService service = new BoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getPathInfo());
		String pageNo = request.getParameter("pageNo");
		String amount = request.getParameter("amount");
		
		// 검색(필터링)을 위한 파라메터
		String searchField = request.getParameter("searchField");
		String searchWord = request.getParameter("searchWord");
		
		// 1. 페이징 처리및 검색조건의 수집
		SearchDto searchDto = new SearchDto(pageNo, amount, searchField, searchWord);
		
		System.out.println("요청파라메터 수집(searchDto) : " + searchDto);
		
		// 2. 목록을 조회
		// ✨ 목록을 조회 하는 조건문과 총 건수를 조회 하는 조건문이 일치해야 페이지블럭이 잘 그려집니다
		// = 조회된 게시물의 건수에 맞게 페이지 블럭이 그려져야 해요!
		List<BoardDto> list = service.getList(searchDto);
		int totalCnt = service.getTotalCnt(searchDto);
		
		// 3. page블럭을 출력하기위해 pageDto객체 생성
		PageDto pageDto = new PageDto(searchDto, totalCnt);
		
		// 4. 내장객체의 영역에 데이터를 저장
		request.setAttribute("list", list);
		// 내장객체(request)의 영역에 pageDto라는 이름으로 pageDto객체를 저장
		request.setAttribute("pageDto", pageDto);
		
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
