<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener('load', ()=>{
		// checkIdBtn을 클릭 하면 아이디 중복검사(/member/checkId)를 진행
		// 입력필드에 입력된 값을 서버에 전송
		checkIdBtn.addEventListener('click', function(){
			console.log('click');
			let user_id = document.querySelector('#user_id');
			// trim() : 공백제거
			if(!user_id.value.trim()){
				showToast('입력체크', '아이디를 입력해주세요.');
				user_id.classList.add('is-invalid');
				return;
			}
			let url = '/member/checkId?user_id=' + user_id.value.trim();
			
			fetch(url) // 요청URL
			  .then(response => response.json())	// 요청결과를 object로 변환
			  .then(result => {
				  	// 서버의 통신결과
			    	console.log(result);
				  	if(!result.res) {
				  		// 중복된 아이디
				  		user_id.classList.add('is-invalid');
				  		showToast('아이디 중복체크', result.msg)
				  	} else {
				  		user_id.classList.remove('is-invalid');
				  	}
				  	
			  })
			  .catch(err=>{
				  	// 네트워크 장애, 매핑된 url이 없는경우
					console.log('err', err);  
			  });
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
<form action="/member/register_action" method="post">
		
	<div class="input-group mb-3 mt-4">
		<input type="text" class="form-control" placeholder="아이디" id="user_id" name="user_id">
		<button class="btn btn-outline-secondary" type="button" id="checkIdBtn">중복체크</button>
	</div>
	
	<div class="input-group mb-3">
		<input type="text" class="form-control is-invalied" placeholder="비밀번호" name="password">
	</div>
	<div class="input-group mb-3">
		<input type="text" class="form-control" placeholder="비밀번호 확인" aria-label="Recipient's username" aria-describedby="button-addon2">
	</div>
	<div class="input-group mb-3">
		<input type="text" class="form-control" placeholder="이름" aria-label="Recipient's username" aria-describedby="button-addon2" name="username">
	</div>
	<div class="input-group mb-3">
		<input type="text" class="form-control" placeholder="email" aria-label="Recipient's username" aria-describedby="button-addon2" name="email">
	</div>
	<div class="input-group mb-3">
		<input type="text" class="form-control" placeholder="전화번호" aria-label="Recipient's username" aria-describedby="button-addon2" name="phone_number">
	</div>
	<div class="input-group mb-3">
		<input type="file" class="form-control" id="inputGroupFile01" name="profile_image_url">
	</div>
	
	<c:if test='${member.hasRole("ADMIN")}'>
	
		<hr>
		<div class="input-group mb-3">
			권한
		</div>
		<div class="input-group mb-3">
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="roles" value="1"> 
			  <label class="form-check-label" for="inlineCheckbox1">시스템관리자</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="checkbox" id="inlineCheckbox2" name="roles" value="2"> 
			  <label class="form-check-label" for="inlineCheckbox2">사용자</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" name="roles" value="3">
			  <label class="form-check-label" for="inlineCheckbox3">파트너</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="checkbox" id="inlineCheckbox4" name="roles" value="4">
			  <label class="form-check-label" for="inlineCheckbox4">등록권한</label>
			</div>
		</div>
	
	</c:if>
	<div class="input-group mb-3 justify-content-md-center">
		<!-- 저장버튼을 클릭 하면 /member/register_action -> 컨트롤러에서 데이터 수집 -->
		<button type="submit" class="btn btn-primary">저장</button>
        <button type="reset" class="btn btn-outline-secondary">초기화</button>
	</div>  
</form>
</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>