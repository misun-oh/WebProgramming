package com.board.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// @WebFilter("/member/*")
// @WebFilter(urlPatterns = {"/member/*", "/board/list.do"})
// @WebFilter(urlPatterns = {"/member/list", "/board/*"})
// /member/list
// /member/login
// /member/loginAction
// /login/loginAction
// /* 모든요청에 대해서 필터를 적용 -> /login/loginAction(로그인 처리) 로그인처리를 하는 URL

// 로그인하지 않은 사용자가 로그인하기 위해 /login/loginAction을 요청
// -> 필터에서 로그인했는지 확인하고 로그인하지 않은 사용자라면 login.jsp로 반환
@WebFilter("/member/*")
public class LoginFilter extends HttpFilter implements Filter {
       
    public LoginFilter() {
        super();
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		// 전처리
		// 시간측정 할때 많이 사용하는 메서드
		// 1970년 1월 1일 00:00:00를 기준으로 시간을 세어준다
		// 밀리초 (1/1000초)
		long startTime = System.currentTimeMillis();
		
		// 로그인 정보를 가지고 오기 위해 HttpServletRequest로 다운 캐스팅
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(session != null) {
			if (session.getAttribute("user_id") == null) {
				String user_id = (String)session.getAttribute("user_id");
				System.out.println("로그인한 사용자의 정보 : " + user_id);
				
				// 로그인 페이지로 전환
				req.getRequestDispatcher("/member/login.jsp").forward(req, response);
				return;
			}
		}
		
		
		chain.doFilter(request, response);
		// 후처리
		long endTime = System.currentTimeMillis();
		System.out.println("startTime : " + startTime);
		System.out.println("end : " + endTime);
		
		System.out.println("수행시간 : "+ (endTime - startTime) + "ms");
		System.out.println("수행시간 : "+ ((endTime - startTime)/1000) + "초");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
