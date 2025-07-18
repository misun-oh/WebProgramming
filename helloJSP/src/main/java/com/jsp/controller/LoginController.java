package com.jsp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login/loginAction2")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출!!");
		// 파라메터 수집
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 로그인 처리 - 서비스에서 처리

		if("13".equals(user_id) && "1234".equals(user_pw)) {
			System.out.println("test");
			// 로그인 성공 -> main.jsp (id님 환영합니다. 메세지 출력)
			// 세션에 사용자 정보를 저장
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user_id);
			
			response.sendRedirect("/login/main.jsp");
		} else {
			System.out.println("test1234");
			//=============== forward
			// 로그인 실패 -> login.jsp (메세지 처리)
			// request영역에 msg를 저장 (아이디 비밀번호가 일치 하지 않습니다.)
			// request.setAttribute("msg", "아이디 비밀번호가 일치 하지 않습니다.");
			
			// 화면 전환 -> forward -> request영역이 공유
			//RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
			//rd.forward(request, response);
			
			//================ redirect
			HttpSession session = request.getSession();
			session.setAttribute("msg", "아이디 비밀번호가 일치 하지 않습니다.");
			session.setAttribute("msg_user_id", user_id);
			response.sendRedirect("/login/login.jsp?");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출!!");
		doGet(request, response);
	}

}
