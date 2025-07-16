<%@page import="com.jsp.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#popup{
		width:300px;
		height:200px;
		border:1px solid;
		position: absolute;
		top:100px;
		left:100px;
	}
	
	#popup>div{
		position: absolute;
		bottom:10px;
		right:10px;
	}
	
	/* 클래스 속성을 이용해서 div박스를 화면에 보여주거나 숨기고 
		싶을때 클래스를 지정*/
	.hidden{
		display:none;
	}
	
</style>

<script type="text/javascript">
	window.onload = function(){
		// 버튼을 클릭하면 공지사항 팝업을 숨김처리 합니다
		closeBtn.addEventListener('click', function(){
			popup.classList.add('hidden');
			// 체크박스(하루동안 열지않음)가 선택 되어 있다면 쿠키를 생성
			// inactiveToday.checked : 요소에 checked 속성이 있다면 true를 반환 
			if(inactiveToday.checked){
				// popupFetchCookie.jsp를 호출
				// 비동기방식으로 페이지를 호출
				fetch('popupFetchCookie.jsp')
				.then(res => res.json())
				.then(data => {
					console.log(data);
					console.log(data.res);
				});
				
			}
		})	
	}
	
</script>
</head>
<body>
<%
	// 쿠키에 popupCookie의 값을 확인 하여 팝업을 제어
	String popupCookie = CookieManager.getCookieValue(request, "popupCookie");
	String hidden = "Y".equals(popupCookie) ? "hidden" : "";
%>
<!-- 쿠키를 이용해서 팝업창을 제어! -->
<!-- 팝업 창 -->
<!-- 쿠키값에 의해서 팝업창을 화면에 보여줄지 숨길지 제어 -->
<div id="popup" class="<%=hidden%>">
    <h2 align="center">공지사항 팝업입니다.</h2>
    <div align="right"><form name="popFrm">
        <input type="checkbox" id="inactiveToday" name="inactiveToday" value="1" />
        하루 동안 열지 않음
        <input type="button" value="닫기" id="closeBtn" />
    </form></div>
</div> 
</body>
</html>