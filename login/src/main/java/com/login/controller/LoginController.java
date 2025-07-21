package com.login.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.login.dto.MemberDto;
import com.login.service.MemberService;

// 톰켓 서버가 요청 받고 일치하는 경로의 해당하는 서블릿을 실행
@WebServlet("/loginAction")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청은 SERVLET으로 응답은 JSP로..
		// 요청정보를 수집하여 콜솔창에 출력
		System.out.println("user_id" +  request.getParameter("user_id") );
		System.out.println("user_pw" +  request.getParameter("user_pw") );

		// 서블릿 응답시 한글깨짐 처리
		// JSP의 상단부에 작성되어 있는 부분
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().append("<h2>로그인 요청</h2>")
							.append(request.getContextPath());
		
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 데이터베이스로 부터 id/pw 정보가 일치하는 사용자를 조회 
		MemberService service = new MemberService();
		MemberDto member = service.login(Integer.parseInt(user_id), user_pw);
		// 서블릿을 이용하여 화면을 구현하는것은 불편 하므로 화면은 JSP에게 위임
		if(member != null) {
			// 사용자 인증 성공 -> main.jsp로 이동
			// 세션에 인증된 사용자의 정보를 저장
			session.setAttribute("user_id", request.getParameter("user_id"));
			session.setAttribute("member", member);
			
			// forward : request영역이 공유됨
			request.getRequestDispatcher("/login/main.jsp")
									.forward(request, response);
		} else {
			// 인증 실패 -> login.jsp로 이동
			// redirect : request영역이 공유되지 않음
			session.setAttribute("msg", "id/pw를 확인해주세요.");
			response.sendRedirect("/login/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
