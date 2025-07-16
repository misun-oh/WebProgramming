
<%@page import="com.jsp.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/common/header.jsp" %>

<script>
window.onload=function(){
	//showModal('타이틀', '메세지');
}

</script>

<main id="wrap">

<%

// 2. 쿠키에 user_id가 저장되어 있다면
String userId = CookieManager.getCookieValue(request, "user_id");
String checked = userId.equals("") ? "" : "checked";

// 3. 쿠키 삭제
//CookieManager.makeCookie(response, "cookie", "맛있는쿠키", 60*60);
CookieManager.deleteCookie(response, "cookie");

%>
    <form method="post" action="/member/loginAction.jsp"> 
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
        	<input class="form-check-input" type="checkbox" name="save_id" value="Y" id="checkDefault" <%=checked %>> 
        	<label class="form-check-label" for="checkDefault">
                아이디 저장하기
            </label> 
        </div> 
        <button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
        <p class="mt-5 mb-3 text-body-secondary">© 2017–2025</p>
    </form>

</main>  



<%@ include file="/common/footer.jsp" %>