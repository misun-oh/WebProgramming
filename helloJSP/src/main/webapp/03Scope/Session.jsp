<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>session영역에 값 저장하기</h2>
<%
	List<String> list = new ArrayList<String>();
	list.add("컬렉션");
	list.add("리스트");
	list.add("맵");
	
	// 로그인
	session.setAttribute("list", list);

	// ✨ forward 방식으로 페이지를 전환
	/*
	request.getRequestDispatcher("SessionForward.jsp")
									.forward(request, response);
	*/
	// ✨ redirect 방식으로 페이지를 전환
	// 서버가 클라이언트에게 다시 요청하라고 전달 -> 요청2번 발생
	request.setAttribute("req", "request영역의 속성");
	
	// application영역에 속성값 추가하기
	// 톰켓 서버가 종료될때까지 데이터를 유지
	application.setAttribute("app", "application영역의 속성");
	
	response.sendRedirect("SessionForward.jsp?id=aaa&pw=1234");
	
%>
</body>
</html>