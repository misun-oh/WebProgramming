<%@page import="com.jsp.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	// 쿠키를 생성
	CookieManager.makeCookie(response, "popupCookie", "Y", 60*60*24);
	//out.print("{\"res\":\"cookie생성\"}");	
%>
{"res":"cookie생성"}