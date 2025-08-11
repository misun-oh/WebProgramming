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
			console.log(user_id);
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
	
	<h1 class="h4 mb-3">회원 등록/수정</h1>

<form id="memberForm" method="post" action="/member/save" onsubmit="return validateMemberForm(event);" novalidate>
    <!-- user_id -->
    <p class="form-floating">
        <input type="text" class="form-control" id="user_id" name="user_id" placeholder="아이디"
               required maxlength="20" />
        <label for="user_id">아이디</label>
    </p>
    <div class="text-danger small" id="err_user_id"></div>

    <!-- username -->
    <p class="form-floating">
        <input type="text" class="form-control" id="username" name="username" placeholder="이름"
               required maxlength="30" />
        <label for="username">이름</label>
    </p>
    <div class="text-danger small" id="err_username"></div>

    <!-- password -->
    <p class="form-floating">
        <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호"
               required maxlength="32" />
        <label for="password">비밀번호</label>
    </p>
    <div class="text-danger small" id="err_password"></div>

    <!-- email -->
    <p class="form-floating">
        <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com"
               required maxlength="100" />
        <label for="email">이메일</label>
    </p>
    <div class="text-danger small" id="err_email"></div>

    <!-- phone_number -->
    <p class="form-floating">
        <input type="text" class="form-control" id="phone_number" name="phone_number" placeholder="010-1234-5678"
               required maxlength="13" />
        <label for="phone_number">휴대폰번호</label>
    </p>
    <div class="text-danger small" id="err_phone_number"></div>

    <!-- profile_image_url -->
    <p class="form-floating">
        <input type="url" class="form-control" id="profile_image_url" name="profile_image_url" placeholder="https://..."
               maxlength="255" />
        <label for="profile_image_url">프로필 이미지 URL(선택)</label>
    </p>
    <div class="text-danger small" id="err_profile_image_url"></div>

    <!-- created_at -->
    <p class="form-floating">
        <input type="datetime-local" class="form-control" id="created_at" name="created_at" placeholder="생성일시" />
        <label for="created_at">생성일시</label>
    </p>
    <div class="text-danger small" id="err_created_at"></div>

    <!-- last_login_at -->
    <p class="form-floating">
        <input type="datetime-local" class="form-control" id="last_login_at" name="last_login_at" placeholder="최근 로그인" />
        <label for="last_login_at">최근 로그인</label>
    </p>
    <div class="text-danger small" id="err_last_login_at"></div>

    <!-- login_fail_count -->
    <p class="form-floating">
        <input type="number" class="form-control" id="login_fail_count" name="login_fail_count" placeholder="0"
               value="0" min="0" step="1" required />
        <label for="login_fail_count">로그인 실패 횟수</label>
    </p>
    <div class="text-danger small" id="err_login_fail_count"></div>

    <!-- account_locked -->
    <p class="form-floating">
        <select class="form-select" id="account_locked" name="account_locked" required>
            <option value="" selected>선택하세요</option>
            <option value="N">N (잠금 아님)</option>
            <option value="Y">Y (잠금)</option>
        </select>
        <label for="account_locked">계정 잠금 여부</label>
    </p>
    <div class="text-danger small" id="err_account_locked"></div>

    <!-- roles -->
    <div class="mb-3">
        <label class="form-label">권한(복수선택 가능)</label>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="role_user" name="roles" value="USER">
            <label class="form-check-label" for="role_user">USER</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="role_admin" name="roles" value="ADMIN">
            <label class="form-check-label" for="role_admin">ADMIN</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="role_manager" name="roles" value="MANAGER">
            <label class="form-check-label" for="role_manager">MANAGER</label>
        </div>
        <div class="text-danger small" id="err_roles"></div>
    </div>

    <div class="d-flex gap-2">
        <button type="submit" class="btn btn-primary">저장</button>
        <button type="reset" class="btn btn-outline-secondary">초기화</button>
    </div>
</form>
	
</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>