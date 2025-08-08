<%@page import="dev.spring.board.dto.PageDto"%>
<%@page import="dev.spring.board.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
	tr.link {
		cursor : pointer;
	}
</style>
<%@include file="/common/header.jsp" %>
<script>
	window.addEventListener('load', function(){
		let searchField = document.querySelector('[name=searchField]');
		searchField.innerHTML = `
	          <option ${param.searchField eq "user_id" ? "selected" : ""} value="user_id">아이디</option>
	          <option ${param.searchField eq "user_id/username" ? "selected" : ""} value="user_id/username">아이디 + 이름</option>
	          <option ${param.searchField eq "username" ? "selected" : ""} value="username">내용</option>`;
	    
	    // DOM을 이용해서 출력 할수 있도록 수정해봅시다
	    
	});
</script>


<div id="wrap">

	<h2>사용자 목록 조회</h2>
	<!-- search.jsp -->
	<%@include file="/common/search.jsp" %>

	<!-- 버튼 시작 -->
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<button class="btn btn-info" onclick="location.href='/member/member_register.jsp'">사용자 등록</button>
	</div>
	<!-- 버튼 끝 -->
	
	<!-- 테이블 시작 -->
	<table  class="table table-hover">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>등록일</th>
		</tr>
		<%
		if(request.getAttribute("list") != null) {
			List<MemberDto> list = (List<MemberDto>)request.getAttribute("list");
			for(MemberDto member : list){
		%>
				
				<tr class="link" onclick="location.href='/member/view.do?id=<%=member.getUser_id() %>'">
					<td><a href="/member/view.do?id=<%=member.getUser_id() %>"><%=member.getUser_id() %></a></td>
					<td><%=member.getUsername() %></td>
					<td><%=member.getCreated_at() %></td>
				</tr>
		<%
			}
		} else {
			out.print("<tr><td colspan='3'>사용자가 존재하지 않습니다.</td></tr>");
		}
		%>
	</table>
	
	<!-- 테이블 시작 -->
	
	<!-- 페이지 블럭 -->
	pageDto : ${pageDto }<br>
	<%
		if(request.getAttribute("pageDto") != null){
			// 내장객체의 영역에 저장된 객체를 변수에 저장
			PageDto pageDto = (PageDto)request.getAttribute("pageDto");
			// 앞으로가기 버튼
			if(pageDto.isPrev()){
				out.print("<");
			}
			int startNo = pageDto.getStartNo();
			int endNo = pageDto.getEndNo();
			// 페이지번호 출력
			for(int i = startNo; i <= endNo; i++){
				out.print("<a onclick='go("+i+")'>"+ i + "</a> ");
			}
			
			// 뒤로가기버튼
			if(pageDto.isNext()){
				out.print(">");
			}
		}
	%>
	
	<%@include file="/common/pageing.jsp" %>
	
	
</div>



<%@include file="/common/footer.jsp" %>
