<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.red{color:red}
</style>
<script>
	window.addEventListener('load', function(){
		let logoutBtn = document.querySelector('#logoutBtn');
		if(logoutBtn != null){
			logoutBtn.addEventListener('click', ()=>{
				//location.href="/member/logout";
				// 스크립트를 이용하여 폼을 서브밋하는 방법
				logoutForm.action="/member/logout";
				logoutForm.method="get";
				logoutForm.submit();
			})
		}
	});
</script>
</head>
<body>
<h1>로그인</h1>
<%
	if(session.getAttribute("user_id") == null) {
%>


<div class="red">${requestScope.msg}</div>
<form name="loginForm" action="/login/loginAction">
	id : <input type="text" name="user_id">
	pw : <input type="text" name="user_pw"> 
	<button>로그인</button>

</form>
<%
	} else {
%>
로그인 id : ${sessionScope.user_id } 님 환영합니다.
	<form name="logoutForm"></form>
	<button id="logoutBtn">로그아웃</button>
<%
	} 
%>
</body>
</html>