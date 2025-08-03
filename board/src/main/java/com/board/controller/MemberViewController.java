package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.board.dto.MemberDto;
import com.board.service.MemberService;

@WebServlet("/member/view.do")
public class MemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id(member테이블의 한 행을 유일하게 식별할수 있는 식별자)를 파라메터로 받아와서
		// 서비스를 통해 1건의 사용자 정보를 조회후 request영역에 저장
		MemberService service = new MemberService();
		
		// id 파라메터 수집
		String id = request.getParameter("id");
		if(id != null) {
			
			MemberDto member = service.getMember(id); 
			
			if(member == null) {
				request.setAttribute("msg", "존재하지 않는 회원 입니다.");
				request.setAttribute("url", "/member/list");
				request.getRequestDispatcher("/common/msgbox.jsp").forward(request, response);
			} else {
				request.setAttribute("member", member);
				// id가 있으면 view.jsp
				//  	없으면 메세지 출력 list.jsp로 화면전환
				System.out.println(request.getRequestURL());
				request.getRequestDispatcher("/member/view.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("msg", "id를 확인할 수 없습니다.");
			request.setAttribute("url", "/member/list");
			request.getRequestDispatcher("/common/msgbox.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
