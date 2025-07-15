<%@page import="com.jsp.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.mapper.BookMapper"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.jsp.utils.MyBatisSessionUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1. 쿠키 설정</h2>
<%
	// 쿠키 생성
	Cookie cookie = new Cookie("test", "test");
	
	// 응답객체를 통해 쿠키를 전달
	response.addCookie(cookie);
	
	// 요청파라메터
	String user_id = request.getParameter("user_id");
	String save_id = request.getParameter("save_id");

	// 아이디 저장하기 체크박스에 체크가 되어 있다면 
	// 사용자아이디를 쿠키에 저장
	if("Y".equals(save_id)){
		Cookie user_id_cookie = new Cookie("user_id", user_id);
		user_id_cookie.setMaxAge(604800); // 60*60*24*7
		user_id_cookie.setPath("/");
		
		response.addCookie(user_id_cookie);
	}
	
	out.print(user_id+"=====================<br>");
	out.print(save_id+"=====================");
%>
<h2>2. 쿠키 값 확인</h2>
<%
	Cookie[] cookies = request.getCookies(); // 요청 헤더에 전달된 쿠키정보를 배열로 반환 
	
	
	String userId = "";
	String checked = "";

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
	
	SqlSession ss = MyBatisSessionUtil.openSession();
	BookMapper mapper = ss.getMapper(BookMapper.class);
	
	List<BookVO> list = mapper.selectBookList();
	System.out.println("==========" + list.size());
%>

<hr>
<form action="">
	<!-- 쿠키의 작동 방식
	클라이언트의 요청 -> 서버에서 클라이언트에 쿠키생성 응답 -> 클라이언트의 브라우저에 쿠키 생성
	 -->
	<!-- name속성이 있으면 서버에 값을 전달 -->
	id : <input type="text" name="user_id" value="<%=userId%>"><br>
	<!-- 체크박스가 체크된 상태일때 서버에 값을 전달 -->
	<input type="checkbox" name="save_id" value="Y" <%= checked %>> 아이디 저장하기<br>
	<button type="submit">로그인</button>
</form>

</body>
</html>