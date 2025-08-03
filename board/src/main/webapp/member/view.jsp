<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- header 영역 -->
<%@include file="/common/header.jsp" %>
<!-- main 영역 -->
<div id="wrap">
	<h2>상세보기</h2>
	
	<div class="form-floating mb-3">
	<input type="text" readonly class="form-control-plaintext" id="id" value="${member.id }">
	<label for="id">아이디</label>
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
		<button class="btn btn-info" onclick="location.href='/member/list'">리스트</button>
		<button class="btn btn-info" onclick="location.href='/member/edit.do?id=${member.id }'">수정</button>
		<button class="btn btn-info" onclick="location.href='/member/delete?id=${member.id }'">삭제</button>
	</div>
</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>