<%@page import="com.jsp.util.CookieManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.jsp.util.ConnectionUtil"%>
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
	// request.getParameter() : 문자열을 반환 하는데 꺼내오려는 값이 없으면 null을 반환
	// 만약 name속성은 있고 value속성 값이 없는경우 빈 문자열로 넘어 옵니다.
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	String save_id = request.getParameter("save_id");
	
	if(user_id == null || user_pw == null || user_id == "" || user_pw == ""){
		out.print("id, pw가 입력 되지 않았습니다.");
		return;
	}
	out.print(user_id+"<br>");
	out.print(user_pw+"<br>");
	out.print(save_id+"<br>");
	
	// 1. 쿠키등록
	// 아이디 저장하기가 체크되어 있다면 쿠키에 아이디를 저장
	if("Y".equals(save_id)){
		CookieManager.makeCookie(response, "user_id", user_id, 60*60*24*7);	
	}
	
	out.print(user_id + "=====");
	out.print(user_pw + "=====");
	
	Connection con = ConnectionUtil.getConnection();
	
	// id - number
	PreparedStatement pstmt = con.prepareStatement("select * from member where id=? and pw=?");
	pstmt.setInt(1, Integer.parseInt(user_id));
	pstmt.setString(2, user_pw);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()){
		String name = rs.getString("name");
		out.print(name + "님 환영 합니다.");
	} else {
		/* 
		out.print("<script>");
		out.print("alert('로그인 실패');");
		out.print("history.back(1);");
		out.print("</script>");
		*/
%>

	<script>
		alert('로그인 실패');
		history.back(1);
	</script>

<%
	}
	
%>
</body>
</html>