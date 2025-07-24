package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.board.dto.MemberDto;
import com.board.service.MemberService;

@WebServlet("/member/edit.do")
public class MemberEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		if(id != null) {
			MemberDto member = service.getMember(id);
			if(member != null) {
				request.setAttribute("member", member);
				request.getRequestDispatcher("/member/edit.jsp").forward(request, response);
				return;
			}
		}
		
		request.setAttribute("msg", "사용자 정보를 확인할 수 없습니다.");
		request.getRequestDispatcher("/common/msgbox.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("pass"));
		System.out.println(request.getParameter("id"));
		doGet(request, response);
	}

}
