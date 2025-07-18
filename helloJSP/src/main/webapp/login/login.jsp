<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.red {color:red;}
</style>
<script>
	window.onload = function(){
		let logoutBtn = document.querySelector('#logoutBtn');
		if(logoutBtn != null){
			logoutBtn.addEventListener('click', ()=>{
				console.log('logoutBtn 클릭!');
				
				// 1. 링크로 요청
				location.href="/login/logout";
			});
		}
	}
</script>
</head>
<body>
<h1>로그인</h1>


<!-- 로그인된 사용자에게는 로그인폼 대신 로그아웃 버튼을 보여준다 -->
<%

	String session_user_id = session.getAttribute("user_id") != null ? (String)session.getAttribute("user_id") : ""; 

	if(!"".equals(session_user_id)){
		// 로그인한 사용자
		out.print(session_user_id + "님 환영합니다.");
		out.print("<button id='logoutBtn'>로그아웃</button>");
	} else {
		// 로그인 하지 않은 사용자
		// 내장객체의 영역에 저장한 경우 getAttribute를 이용해서 값을 꺼내와요
		//String msg = request.getAttribute("msg") != null ? (String)request.getAttribute("msg") : "";
		String msg = session.getAttribute("msg") != null ? (String)session.getAttribute("msg") : "";
		session.removeAttribute("msg");
		String user_id = session.getAttribute("msg_user_id") != null ? (String)session.getAttribute("msg_user_id") : "";
		session.removeAttribute("msg_user_id");
%>
<div class="red"><%=msg %></div>
<!-- 경로를 줄때 앞에 아무것도 적지 않는것은 나를 기준으로 -->
<form action="/login/loginAction2">
	id : <input type="text" name="user_id" value=<%=user_id %>>
	<br>pw : <input type="text" name="user_pw">
	<br><button type="submit">로그인</button>
</form>
<%
	} 
%>
</body>
</html>