<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*


fetch(url) // 요청URL
.then(response => response.json())	// 요청결과를 object로 변환
.then(result => {
	  	// 서버의 통신결과
  	console.log(result);
})
.catch(err=>{
	  	// 네트워크 장애, 매핑된 url이 없는경우
		console.log('err', err);  
});


*/
</script>
</head>
<body>
<!-- header 영역 -->
<%@include file="/common/header.jsp" %>
<!-- main 영역 -->
<div id="wrap">

</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>