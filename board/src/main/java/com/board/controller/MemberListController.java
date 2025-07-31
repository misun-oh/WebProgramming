package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.board.dto.MemberDto;
import com.board.dto.PageDto;
import com.board.dto.SearchDto;
import com.board.service.MemberService;

// 요청은 서블릿으로 응답은 JSP로 
@WebServlet("/member/list")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		
		// 페이징 처리가 되어 있는 메서드로 변경
		//List<MemberDto> list = service.getMemberList();
		// 화면으로 부터 전달받은 파라메터를(요청정보) 수집하여 searchDto를 만들고 service의 파라메터로 전달
		
		// 페이지 처리를 위한 파라메터 
		// ✨ 파라메터가 존재 하지 않는경우 null이 반환됨
		String pageNo = request.getParameter("pageNo");
		System.out.println("pageNo(요청페이지 번호) : " + pageNo);
		String amount = request.getParameter("amount");
		System.out.println("amount(페이지당 게시물 수) : " + pageNo);

		// 검색을 위한 파라메터
		String searchField = request.getParameter("searchField");
		String searchWord = request.getParameter("searchWord");
		
		// SearchDto - 검색을 위한 파라메터, 페이지 처리를 위한 파라메터 세팅
		SearchDto search = new SearchDto(pageNo, amount, searchField, searchWord);
		
		// 리스트를 출력하기 위한 쿼리
		List<MemberDto> list = service.getMemberListPageing(search);
		// 총 건수를 조회 하는 쿼리 - 페이지 블럭을 그리는데 필요
		int totalCnt = service.getTotalCnt(search);
				
		// 내장객체의 영역에 list를 담아 화면에 전달
		request.setAttribute("list", list);
		
		// 페이지블럭을 그리기 위해 pageDto객체를 생성합니다.
		// TODO 총건수를 조회 하는 쿼리가 필요
		PageDto pageDto = new PageDto(search, totalCnt);
		request.setAttribute("pageDto", pageDto);

		// SERVLET으로 요청을 받은후 JSP로 화면을 전환
		request.getRequestDispatcher("/member/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
