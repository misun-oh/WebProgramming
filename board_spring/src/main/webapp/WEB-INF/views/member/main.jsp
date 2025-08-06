<%@page import="dev.spring.board.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/header.jsp" %>


<div id="wrap">

	<h1>로그인 성공!!</h1>
	<%=session.getAttribute("user_id") %>
	
	<h2>표현언어를 이용하여 변수의 값을 출력 해봅시다</h2>
	${sessionScope.user_id}님 환영합니다.
	${user_id}님 환영합니다.
	${aaaa }이런건 없어요!
	
	<a href="/member/login.jsp">로그인페이지로 이동 하기</a>
	
	<h2>사용자 목록 조회</h2>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>등록일</th>
		</tr>
		<%
		if(session.getAttribute("list") != null) {
			List<MemberDto> list = (List<MemberDto>)session.getAttribute("list");
			for(MemberDto member : list){
		%>
				<tr>
					<td><%=member.getId() %></td>
					<td><%=member.getName() %></td>
					<td><%=member.getRegidate() %></td>
				</tr>
		<%
			}
		} else {
			out.print("<tr><td colspan='3'>사용자가 존재하지 않습니다.</td></tr>");
		}
		%>
	</table>
</div>
<%@include file="/common/footer.jsp" %>

