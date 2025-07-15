package com.jsp.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManager {

	/**
	 * 쿠키 생성 후 response객체에 추가
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
	
	
}
