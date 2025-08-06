<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener('load', ()=>{
		// 버튼을 클릭 하면 실행할 함수를 작성
		// 서브밋 -> 기존 이벤트 초기화
		// user_id의 class목록에 is-invalid가 있으면 메세지 처리후 종료(return)
		signupBtn = document.querySelector('#signupBtn');
		signupBtn.addEventListener('click', (e)=>{
			e.preventDefault();
			if(user_id.classList.contains('is-invalid')){
				showModal('회원등록', '중복된 아이디 입니다.');
				return;
			}
				
		})
		
		let user_id = document.querySelector('#user_id');
		// 아이디에 입력값이 변경되면 콘솔창에 출력
		// change : 포커스가 빠질때
		// input : 입력할때 마다
		user_id.addEventListener('input', ()=>{
			// 아이디가 변경될때마다 서버에서 사용가능한 아이디 인지 확인
			fetch('/member/idCheck?id='+user_id.value)
			.then(response => response.json())
			.then(res=>{
				console.log(res.idCheck);
				if(res.idCheck){
					// true = 사용가능 -> is-invalid class 제거
					user_id.classList.remove('is-invalid');		
				} else {
					// false = 사용불가 -> is-invalid class 추가
					user_id.classList.add('is-invalid');
				}
			})
		})
	})
</script>
</head>

<body>
<!-- header 영역 -->
<%@include file="/common/header.jsp" %>
<!-- main 영역 -->
<div id="wrap">
<h2>사용자 등록</h2>
<form action="/member/registerAction">

	<p class="form-floating">
	<input type="text" class="form-control" id="user_id" placeholder="name@example.com">
	<label for="user_id">아이디</label>
	</p>
	
	
	id : <input type="text" name="id"> 
	<br>pw : <input type="text" name="pass">
	<br>pw 확인 : <input type="text" id="pass_check">
	<br>이름 :  <input type="text" name="name">
	
	<p></p>
	<button id="signupBtn">사용자 등록</button>
	
</form>
</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>