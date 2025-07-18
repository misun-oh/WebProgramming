<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <!-- 외부 스타일 시트 -->
    <!-- 
    / : 최상위 폴더 	- 절대경로 (webapp)
    ./ : 현재위치		- 상대경로
    ../ : 상위폴더 	- 상대경로
    ../css/style.css 
    -->
    <link rel="stylesheet" href="/css/style.css">
    <!-- 외부 스크립트 파일을 불러오기 -->
    <script src="/js/script.js"></script>
</head>
<body>

    <div id="container">
        <header class="p-3 text-bg-dark">
            <!-- header -->
            <div class="container"> <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start"> <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"> <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg> </a> <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"> <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li> <li><a href="#" class="nav-link px-2 text-white">Features</a></li> <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li> <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li> <li><a href="#" class="nav-link px-2 text-white">About</a></li> </ul> <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search"> <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search"> </form> <div class="text-end">
			<%
				// 로그인 되었는지 확인
				if(session.getAttribute("user_id")!=null ) {
			%>
                <button id="logoutBtn" type="button" class="btn btn-outline-light me-2">로그아웃</button>
            <%
				} else {
            %> 
            	<button id="loginBtn" type="button" class="btn btn-outline-light me-2">로그인</button>
                <button id="signUpBtn" type="button" class="btn btn-warning">회원가입</button>
            <%	} %> 
            </div> </div> </div> 
        </header>
<!-- header.jsp 끝 -->