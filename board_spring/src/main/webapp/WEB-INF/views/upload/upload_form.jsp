<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>다중 파일 업로드</h1>
<form action="<c:url value='/upload/upload_action'/>" method="post" enctype="multipart/form-data">
  <input type="file" name="files" multiple />
  <!-- (선택) 사용자 ID 등 메타 -->
  <input type="text" name="userId" placeholder="userId" value="momo"/>
  <button type="submit">업로드</button>
</form>

</body>
</html>