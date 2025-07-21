<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 성공</h2>
<!-- 표현언어(el)을 이용하면 null처리와 오류에 관대하며 값이 없는 경우 아무것도 출력 하지 않는다!!! 
	표현언어를 이용하면 4가지 영역에 저장된 값을 쉽고 편리하게 출력 할 수 있다
	영역을 지정 하지 않으면 작은 영역부터 큰영역까지 순서대로 찾아서 값이 있으면 출력한다!
-->
${sessionScope.user_id }님 환영합니다.
${sessionScope.member.name }님 환영합니다.
<h2>파라메터로 전달된 값을 확인</h2>
<p>request.getParameter()로 꺼내오는값을 표현언어를 이용하면 편리하게 사용할 수 있어요!</p>
<p>id : ${param.user_id }</p>
<p>pw : ${param.user_pw }</p>
<p>값이 없는경우 : ${param.user }</p>

<br><a href="/login/login.jsp">로그인 페이지로 이동</a>
</body>
</html>