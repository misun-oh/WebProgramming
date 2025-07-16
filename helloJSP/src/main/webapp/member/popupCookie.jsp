<%@page import="com.jsp.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//  request.getParameter("test") : 요청객체로 부터 test라는 이름의 파라메터를 수집
	String test = request.getParameter("test");
	out.print("test : " + test); // test 라는 요청파라메터가 없는 경우(name속성의 값이) 없는 경우 null이 반환 

	if("Y".equals(test)){
		// 만약 체크박스에 체크가 된 상태일때만 쿠키를 생성하고 싶어
		// 체크박스에 체크가 된 상태 = 파라메터가 넘어 왔을때
		CookieManager.makeCookie(response, "popupCookie", "Y", 60*60*24);
		out.print("쿠키 생성");		
	}
%>

</body>
</html>