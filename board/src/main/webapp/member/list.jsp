<%@page import="com.board.dto.PageDto"%>
<%@page import="com.board.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
	tr.link {
		cursor : pointer;
	}
</style>
<script>
	// 페이지블럭의 버튼을 클릭 했을때 리스트 페이지를 요청
	// 페이지 번호, 페이지당게시물수를 파라메터로 넘겨주는 역할
	function go(pageNo){
		console.log("pageNo : ", pageNo);
		// pageNo를 매개변수로 넘어온 값으로 변경
		document.querySelector("[name=pageNo]").value = pageNo;
		// form 전송
		searchForm.submit();
		
	}
</script>
<%@include file="/common/header.jsp" %>

<div id="wrap">

	<h2>사용자 목록 조회</h2>
	

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
				
				<tr class="link" onclick="location.href='/member/view.do?id=<%=member.getId() %>'">
					<td><a href="/member/view.do?id=<%=member.getId() %>"><%=member.getId() %></a></td>
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
		};
	%>
	
	<form action="/member/list" name="searchForm">
		pageNo : <input type="text" name="pageNo" value="${pageDto.pageNo }"><br>
		amount : <input type="text" name="amount" value="${pageDto.amount }">
	</form>
</div>



<%@include file="/common/footer.jsp" %>
