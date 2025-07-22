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
<h2>사용자 등록</h2>
<form action="/member/registerAction">
	
	id : <input type="text" name="id"> 
	<br>pw : <input type="text" name="pass">
	<br>pw 확인 : <input type="text" id="pass_check">
	<br>이름 :  <input type="text" name="name">
	
	<p></p>
		<button>사용자 등록</button>
	
</form>
</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>