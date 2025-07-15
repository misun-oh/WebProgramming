<!-- 페이지 지시자 : JSP페이지에 대한 정보를 설정 (JSP페이지를 서블릿코드로 변환 하는데 필요한 정보) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- 스크립트 요소 : 자바코드를 작성할 수 있는 영역 -->
<%! // 선언부 (메서드, 멤버변수 선언)
%>
<%	// 스크립틀릿 (자바코드 작성)   
%>
<!-- 표현식 : 실행결과로 하나의 값을 화면에 출력 
			상수, 변수, 연산자를 이용한 수식-->
<%=10 %>
<%
	String str1 = "JSP";
	String str2 = "반갑습니다!";
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 인클루드 지시어 : 반복되는 부분을 별도의 파일로 작성해 두고 필요한 페이지에서 include지시어로 포함-->
<%@ include file="/common/header.jsp" %>
<hr>



<!-- 하나의 값을 출력 할 때 -->
<%=str1 %>
<!-- 여러 문장을 이용할 때
	반복문, 제어문도 이용이 가능
 -->
<%
	out.println(str2);
%>
<h2>나의 첫 JSP</h2>
</body>
</html>