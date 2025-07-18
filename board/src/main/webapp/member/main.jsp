<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 성공!!</h1>
<%=session.getAttribute("user_id") %>

<h2>표현언어를 이용하여 변수의 값을 출력 해봅시다</h2>
${sessionScope.user_id}님 환영합니다.
${user_id}님 환영합니다.
${aaaa }이런건 없어요!

<a href="/member/login.jsp">로그인페이지로 이동 하기</a>
</body>
</html>