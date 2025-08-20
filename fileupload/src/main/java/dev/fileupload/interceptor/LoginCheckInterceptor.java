package dev.fileupload.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle==========================");
		HttpSession session = request.getSession();
	    if (session == null || session.getAttribute("member") == null) {
	    	session.setAttribute("msg", "로그인후 이용 가능 합니다.");
	    	session.setAttribute("requestUrl", request.getRequestURI());
	        response.sendRedirect("/member/login");
	        return false;
	    }
		return true;
	}
}
