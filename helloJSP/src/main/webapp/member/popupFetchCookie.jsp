<%@page import="com.jsp.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키를 생성
	CookieManager.makeCookie(response, "popupCookie", "Y", 60*60*24);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

</body>
</html>