<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>세션영역에 저장된 속성 값을 확인</h2>
<p>웹브라우저 창을 모두 닫을 때까지 유지</p>
<%= session.getAttribute("list") == null ? "값 없음" : session.getAttribute("list")%>

<h2>request영역에 저장된 속성 값을 확인</h2>
<%= request.getAttribute("req") == null ? "값 없음" : request.getAttribute("req")%>

<h2>쿼리스트링으로 넘긴 값 읽어 오기</h2>
id : <%= request.getParameter("id") %>
pw : <%= request.getParameter("pw") %>

<h2>application영역에 저장된 속성 값을 확인</h2>
<%=application.getAttribute("app") == null ? "값 없음" : application.getAttribute("app") %>

</body>
</html>



