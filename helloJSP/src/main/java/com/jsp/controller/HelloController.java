package com.jsp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 1. url 매핑 - 요청주소에 의해서 서블릿이 실행
@WebServlet("/hello")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    // 2. 호출 방식에 따라 실행되는 메서드가 결정
    //    매개변수로 내장객체가 전달됨 - request, response
    // 	  JSP에서 제공되었던 여러가지 내장 객체들은 request, response객체로 부터 꺼내서 사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.append("<h1>hello Servlet</h1>");
		pw.append("id : <input type='text'>");
		
		System.out.println("/hello 서블릿 동작");
		// jsp로 페이지를 전환
		response.sendRedirect("/member/login_cookie.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
