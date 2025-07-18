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
<%@include file="/common/header.jsp" %>
세션 만료 시간 : <%=session.getMaxInactiveInterval() %>초
<br>WEB.XML의 설정의 의해서 동작
<br>세션 ID : <%=session.getId() %>
<br>  
<%
	session.setMaxInactiveInterval(60*60);
	out.print("변경후 세션 만료 시간 : " + session.getMaxInactiveInterval());


	String userId = CookieManager.getCookieValue(request, "chk_save_id");
	String checked = "".equals(userId) ? "" : "checked";
	
	/*
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		// 쿠키의 이름으로 값을 찾아 옵니다.
		if("chk_save_id".equals(c.getName())){
			// 아이디 입력창에 아이디를 출력
			userId = c.getValue();
			// 체크박스에 체크된 상태를 표시
			checked = "".equals(userId) ? "" : "checked";
		}
	}*/
%>
<!-- 404오류 : 요청 주소에 페이지(url매핑)가 없는경우 
	form의 action값을 확인!!!!!!!
-->

<%
// 로그인사용자의 경우 xx님 환영합니다 메세지를 출력
if(session.getAttribute("user_id") != null){
	String user_id = (String)session.getAttribute("user_id");
	out.print(user_id + "님 환영 합니다.");
} else {
	
%>
<!-- 서블릿을 호출 할 수 있도록 요청 경로를 지정 -->
<form method="get" action="/member/loginAction"> 
    <img class="mb-4" src="../img/cat.jpg" alt="" width="100" height="100">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    <div class="form-floating">
    	<input type="text" class="form-control" id="floatingInput" name="user_id" value="<%=userId%>"> 
    	<label for="floatingInput">id</label> 
    </div>
    <div class="form-floating">
    	<input type="password" class="form-control" id="floatingPassword" name="user_pw"> 
    	<label for="floatingPassword">pw</label> 
    </div>
    <div class="form-check text-start my-3"> 
    	<!-- 체크된 상태일때만 값이 서버로 전달 -->
    	<input class="form-check-input" type="checkbox" name="chk_save_id" value="Y" id="checkDefault" <%=checked %>> 
    	<label class="form-check-label" for="checkDefault">
            아이디 저장하기
        </label> 
    </div> 
    <button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
    <p class="mt-5 mb-3 text-body-secondary">© 2017–2025</p>
</form>
<%} %>

<%@include file="/common/footer.jsp" %>
</body>
</html>