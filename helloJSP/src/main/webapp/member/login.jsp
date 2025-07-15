
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
String user_id = request.getParameter("user_id");
String user_pw = request.getParameter("user_pw");
String save_id = request.getParameter("save_id");

out.print(user_id+"<br>");
out.print(user_pw+"<br>");
out.print(save_id+"<br>");

// 1. 쿠키등록
// 아이디 저장하기가 체크되어 있다면 쿠키에 아이디를 저장
if("Y".equals(save_id)){
	CookieManager.makeCookie(response, "user_id", user_id, 60*60*24*7);	
}

// 2. 쿠키에 user_id가 저장되어 있다면
Cookie[] cookies = request.getCookies(); // 요청 헤더에 전달된 쿠키정보를 배열로 반환 

String userId = "";
String checked = "";

out.print("쿠키에 저장된 정보를 출력합니다.===============================<br>");

if(cookies != null){
	for(Cookie c : cookies){
		// 서버에 전달된 쿠키 정보를 출력!!
		out.println(c.getName() + "/" + c.getValue() + "<br>");
		
		// 쿠키에 로그인 아이디가 저장되어 있으면 변수에 저장해서 화면에 출력!!!!!
		if(c.getName().equals("user_id")){
			userId = c.getValue();
			//checked = "checked";
			checked = userId.equals("") ? "" : "checked";
		}
	}
}


%>
    <form method="get"> 
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