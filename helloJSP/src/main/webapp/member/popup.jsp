<%@page import="com.jsp.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    div#popup {
        position: absolute; top:100px; left:50px; color:yellow;  
        width:270px; height:100px; background-color:gray;
         
    }
    div#popup>div {
        position: relative; background-color:#ffffff; top:0px;
        border:1px solid gray; padding:10px; color:black;
    }
    /* 스타일 클래스를 만들어 놓으면 class속성에다가 사용 */
    .red{
    	color:red;
    }
    .none {
    	/* 화면에서 숨김 */
    	display:none;
    }
    
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	// popupCookie 쿠키에 Y값이 저장 되어 있다면 팝업창을 띄우지 않아야 함!!!
	String popupCookie = CookieManager.getCookieValue(request, "popupCookie");
	
	String none = "Y".equals(popupCookie) ? "none" : "";
%>


<script type="text/javascript">
	
	// 버튼을 클릭을 하면 환영합니다 메세지 출력
	window.onload = function(){
		console.log('test');
	}
	window.addEventListener('load', function(){
		
		let closeBtn = document.querySelector('#closeBtn');
		closeBtn.addEventListener('click', function(){
			console.log('닫기 버튼 클릭!');
			let popup = document.querySelector('#popup');
			//popup.style.display = 'none';
			// 화면에서 숨기기
			popup.classList.add('none');
			
			// 하루동안 보지 않기가 체크된 경우
			let inactiveToday = document.querySelector('#inactiveToday');
			// 체크박스.checked : 체크박스가 선택 되었으면 true를 반환, 아니면 false를 반환
			if(inactiveToday.checked){
				// 쿠키생성 페이지 호출
				// 폼의 이름으로 폼 요소를 선택
				popFrm.action = "popupCookie.jsp";
				popFrm.target = "iframeTarget"
				popFrm.submit();
			}
			
		});
	})
</script>
</head>
<body>
<h2>쿠키를 이용하여 팝업을 제어해봅시다!</h2>
<iframe name="iframeTarget" class="none">

</iframe>
<div id="popup" class="<%=none%>">
	
    <h2 align="center">공지사항 팝업입니다.</h2>
    <div align="right" >
	    <form name="popFrm" class="red" id="redTest">
	    
	        <input type="checkbox" id="inactiveToday" name="test" value="Y" />
	        하루 동안 열지 않음
	        <input type="button" value="닫기" id="closeBtn" />
	    </form>
    </div>
</div>


</body>
</html>