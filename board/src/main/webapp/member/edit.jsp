<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener('load', ()=>{
		let viewBtn = document.querySelector('#viewBtn');
		viewBtn.addEventListener('click', ()=>{
			location.href = '/member/view.do?id=${member.id}';
		})
		
		let editBtn = document.querySelector('#editBtn');
		editBtn.addEventListener('click', (e)=>{
			e.preventDefault();
			// 유효성검사
			// 비밀번호가 입력되었는지 확인
			// 자바스크립트에서 falsy한 값이란 조건문 등에서 자동으로 false처럼 취급되는 값을 의미
			// null, '', 0, -0, NaN, undefined
			if(!pass.value){
				// ''이면 실행 -> (true)
				showModal('수정', '비밀번호를 입력해주세요.');
				return;
			}
			// 비밀번호와 비밀번호 확인이 일치하는지 확인
			if(pass.value != pass_check.value){
				// ''이면 실행 -> (true)
				showModal('수정', '비밀번호가 일치하지 않습니다.');
				return;
			}
			
			// 폼 전송(요청)
			editForm.submit();
		})
	})
</script>
</head>
<body>
<!-- header 영역 -->
<%@include file="/common/header.jsp" %>
<!-- main 영역 -->
<div id="wrap">
	<h2>수정</h2>
	<form action="/member/edit.do" method="post" name="editForm">
	 
		<div class="form-floating mb-3">
		<input type="text" readonly class="form-control-plaintext" id="id" name="id" value="${member.id }">
		<label for="id">아이디</label>
		</div>
		<div class="form-floating mb-3">
		<input type="text" class="form-control" id="pass" name="pass" value="">
		<label for="pass">비밀번호</label>
		</div>
		<div class="form-floating mb-3">
		<input type="text" class="form-control" id="pass_check" value="">
		<label for="pass_check">비밀번호 확인</label>
		</div>
		<div class="form-floating mb-3">
		<input type="text" readonly class="form-control-plaintext" id="name" value="${member.name}">
		<label for="name">이름</label>
		</div>
		<div class="form-floating mb-3">
		<input type="text" readonly class="form-control-plaintext" id="regidate" value="${member.regidate}">
		<label for="regidate">가입일</label>
		</div>
	
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<button class="btn btn-info" id="viewBtn" type="button" onclick="location.href = '/member/view.do?id=${member.id}'">상세보기로 이동</button>
			<button class="btn btn-info" id="editBtn">수정</button>
		</div>
	</form>
</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>