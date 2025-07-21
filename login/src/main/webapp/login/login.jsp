<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener('load', function(){
		let logoutBtn = document.querySelector('#logoutBtn');
		
		// 버튼이 화면에 있을때만 이벤트를 적용!!
		if(logoutBtn != null){
			logoutBtn.addEventListener('click', () => {
				location.href="/logoutAction";
			});			
		}
		
		let loginBtn = document.querySelector('#loginBtn');
		if(loginBtn != null){
			// 이벤트에 대한 정보를 첫번째 파라메터로 전달
			loginBtn.addEventListener('click', (e) => {
				// 기본 이벤트를 제거하여 서브밋이 되는것을 방지
				e.preventDefault();
				// 유효성 검사
				// 사용자의 입력값을 체크
				let user_id = document.querySelector("[name=user_id]");
				if(user_id.value == ""){
					alert("아이디를 입력해주세요");
					return;
				}
				let user_pw = document.querySelector("[name=user_pw]");
				if(user_pw.value == ""){
					alert("비밀번호를 입력해주세요");
					return;
				}
				
				// 서버에 요청
				// 폼이름으로 요소를 선택
				loginForm.submit();
				
			});			
		}
	});
</script>
</head>
<body>
<h1>로그인</h1>
<!-- /loginAction 요청을 실행할 서블릿을 만들고 id/pw를 콘솔창에 출력 
	id=13, pw=1234 이면 로그인 성공 -> /login/main.jsp로 이동
									아이디님 환영합니다. 메세지 출력
					아니면 로그인 실패 -> login.jsp로 이동
									아이디 비밀번호를 확인하세요. 메세지 출력
	
-->
<!-- action속성을 주지 않으면 자기자신(현재페이지)를 다시 호출 -->

<!-- 로그인된 사용자의 경우 로그아웃 버튼이 아닌경우에는 로그인폼을 화면에 출력 -->
<%
	if(session.getAttribute("user_id") != null &&
			!session.getAttribute("user_id").equals("")){
		// 인증(로그인)된 사용자
		out.print(session.getAttribute("user_id") + "님 환영합니다.");
		out.print("<br><button id='logoutBtn'>로그아웃</button>");
	} else {
		// 로그인 안된 사용자
	
%>
<form action="/loginAction" name="loginForm">
	${sessionScope.msg }
	<br>id <input type="text" name="user_id">
	<br>pw <input type="password" name="user_pw">
	<br><button id="loginBtn">로그인</button>
	<%
		// 세션영역에 저장된 메세지를 삭제
		session.removeAttribute("msg");
	%>
</form>
<%
	} 
%>
</body>
</html>