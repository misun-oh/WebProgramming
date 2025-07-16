<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 파라메터(아이디, 비밀번호, 체크박스)를 받아서 출력
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String chk_save_id = request.getParameter("chk_save_id");
	
	// 입력 값 체크
	if(user_id == null || "".equals(user_id) || user_pw == null || "".equals(user_pw) ){
		out.print("<script>");
		out.print("alert(\"아이디 또는 비밀번호가 입력 되지 않았습니다.\");");
		out.print("history.back(1);");
		out.print("</script>");
		// 요기서 종료
		return;
	}
	
	// 만약 체크박스에 체크가 되어 있다면 쿠키를 생성하여 response객체에 추가
	if("Y".equals(chk_save_id)){
		// 쿠키의 name과 value값을 초기 파라메터로 전달
		Cookie cookie = new Cookie("chk_save_id", user_id);
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
	}
%>

<h2>파라메터 출력</h2>
<%=user_id %><br>
<%=user_pw %><br>
<%=chk_save_id %><br>


</body>
</html>