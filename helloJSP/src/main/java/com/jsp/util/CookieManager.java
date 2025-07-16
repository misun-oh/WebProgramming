package com.jsp.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManager {

	/**
	 * 쿠키 생성 후 응답객체(response)객체에 추가
	 * @param res
	 * @param cName
	 * @param cValue
	 * @param cTime
	 */
	public static void makeCookie(HttpServletResponse res, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName, cValue);
		cookie.setMaxAge(cTime);
		
		res.addCookie(cookie);
	}
	
	/**
	 * 요청객체(request)로 부터 쿠키배열을 꺼내온 후 원하는 쿠키값을 반환 
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest req, String cName) {
		String cookieValue = "";
		// 요청 객체로 부터 쿠키배열을 꺼내오기
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies) {
			// 쿠키의 name값이 일치 하면 value를 반환
			if(cookie.getName().equals(cName)) {
				cookieValue = cookie.getValue();
				break;
			}
		}
		return cookieValue;
	}
	
	// 쿠키 삭제 = 만료시간을 0으로 만들어 주면 삭제 됨
	// 삭제하려는 쿠키의 이름으로 새로운 쿠키를 만들어서 만료시간을 0으로 지정한 후 응답객체 전달
	public static void deleteCookie(HttpServletResponse res, String cName) {
		makeCookie(res, cName, "", 0);
	}
	
}
