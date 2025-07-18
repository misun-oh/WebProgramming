<%@page import="com.jsp.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>request 영역에 값을 저장 해봅시다</h1>
<%
	// 스크립틀릿 안에 자바코드를 작성
	// 내장객체의 영역에 속성값을 추가하기(저장하기)
	request.setAttribute("name", "오미자");

	// 내장객체의 영역에 속성값을 제거하기
	request.removeAttribute("name");
	
	// Person객체를 생성하고 request영역에 담아 보기
	Person person = new Person("정민서", 20);
	request.setAttribute("person", person);
	
	// 내장객체의 영역에 저장된 속성값을 읽어오기
	if(request.getAttribute("name") != null){
		String name = (String)request.getAttribute("name");
		out.print(name);
	}
	
	if(request.getAttribute("person") != null){
		out.print("<br>" + request.getAttribute("person"));
		Person p = (Person)request.getAttribute("person");
		out.print("<br>이름 : " + p.getName());
		out.print("<br>나이 : " + p.getAge());
	}
%>
<h1>forward된 페이지에서 request영역의 값 확인하기</h1>
<p>페이지 전환(forward, redirect)</p>

<%
	// 현재페이지를 기준으로 위치 잡는다
	// / : 최상위경로, ../ : 상위경로,  ./ : 현재위치
	request.getRequestDispatcher("RequestForward.jsp?t=한글&tt=e")
						.forward(request, response);
%>

<h1>page영역에 속성값 추가</h1>
<%
	pageContext.setAttribute("pageName", "page영역에 값을 저장 합니다.");

	out.print("pageName : " + pageContext.getAttribute("pageName"));
%>










</body>
</html>