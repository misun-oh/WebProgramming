package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login/loginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		HttpSession session = request.getSession();
		
		// DB에 접근해서 Member객체를 반환 받아 오도록 수정
		if("13".equals(user_id) && "1234".equals(user_pw)) {
			// 인증된 사용자의 정보를 session객체의 속성으로 추가 하여 로그인 처리를 한다
			session.setAttribute("user_id", user_id);
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
