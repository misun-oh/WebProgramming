<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- header 영역 -->
<%@include file="/common/header.jsp" %>
<!-- main 영역 -->
<div id="wrap">
<h2>board list</h2>
리스트 : ${list }
<!-- pageDto를 이용해서 페이지 블럭을 화면에 출력 -->
<%@ include file="/common/pageing.jsp" %>
</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>