<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forward된 페이지</h1>
<p>서버에서 내부적으로 페이지를 전환</p>
<p>주소표시줄의 주소가 변경되지 않는다</p>
<p>✨하나의 요청이므로 요청정보(request영역)이 공유 된다!!!!!</p>
<p>단독으로 호출 하면 요청영역이 공유 되지 않으므로 출력되지 않는다!!!</p>
<%
	// 내장객체의 영역에 저장된 person이라는 이름의 객체를 반환
	if(request.getAttribute("person") != null){
		
		out.print(request.getAttribute("person"));
	}

	//내장객체의 영역에 저장된 속성값을 읽어오기
	if(request.getAttribute("name") != null){
		String name = (String)request.getAttribute("name");
		out.print("이름 : " + name);
	} else {
		out.print("request영역에 name속성이 존재하지 않습니다.");
	}
%>
<h2>페이지 영역의 값 읽어오기</h2>
<p>페이지가 전환되면 영역의 값은 유지 되지 않는다 (null을 출력)</p>
pageName : <%= pageContext.getAttribute("pageName") %>
</body>

</html>










