package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.board.dto.MemberDto;
import com.board.service.MemberService;

@WebServlet("/login/loginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberService service = new MemberService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		HttpSession session = request.getSession();
		
		MemberDto member = service.login(user_id, user_pw);
		// DB에 접근해서 Member객체를 반환 받아 오도록 수정
		if(member != null) {
			// 인증된 사용자의 정보를 session객체의 속성으로 추가 하여 로그인 처리를 한다
			session.setAttribute("user_id", user_id);
			
			// 사용자 목록을 조회후 영역에 저장
			List<MemberDto> list = service.getMemberList();
			session.setAttribute("list", list);
			System.out.println("===" + list);
			response.sendRedirect("/member/main.jsp");
		} else {
			request.setAttribute("msg", "아이디/비밀번호를 확인 해주세요");
			// 화면 전환
			request.getRequestDispatcher("/member/login.jsp")
											.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
