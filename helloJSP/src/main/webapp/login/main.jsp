<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String user_id = session.getAttribute("user_id") != null 
						? (String)session.getAttribute("user_id") : ""; %>

<%=user_id %>님 환영 합니다.

<a href="/login/login.jsp">로그인 페이지로 이동 하기</a>
</body>
</html>