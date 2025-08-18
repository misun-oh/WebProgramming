<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 

	1. 페이지 잘 띄우기 - 경로
	2. 데이터 수집 

-->
<h1>파일 업로드</h1>

<!-- ❗파일을 전송 하기 위해서 enctype을 multipart/form-data로 지정 합니다!

<form> 태그의 enctype 속성
폼 데이터(form data)가 서버로 제출될 때 해당 데이터가 인코딩되는 방법을 명시


 -->
<form action="/upload/upload" method="post" enctype="multipart/form-data">
	user_id <input type="text" name="user_id" value="100"><br>
	<!-- 다중 파일을 첨부할 경우, multiple="multiple" 옵션을 줄수 있다! -->
	첨부파일 <input type="file" name="file"><br>
	<button type="submit">업로드</button>
</form>

</body>
</html>