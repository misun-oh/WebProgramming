<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그아웃</h2>
<p>1. 회원정보를 삭제</p>
<%
	session.removeAttribute("user_id");
%>
<p>2. 모든정보를 한번에 삭제</p>
<%
	session.invalidate();

	// 페이지 전환
	response.sendRedirect("/member/login.jsp");
%>


</body>
</html>