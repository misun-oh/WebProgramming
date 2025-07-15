<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	// 선언부 - 메서드 선언, 전역변수 선언
	String title = "servlet/jsp";
	
	public int add(int a, int b){
		return a+b;
	}
%>

<h2>스크립트 요소</h2>
- 선언부<br>
- 스크립틀릿<br>
<%
	int result = add(10, 20);
	out.print(result);
%>
- 표현식<br>
<%= result%>
<%= add(30, 40)%>



</body>
</html>