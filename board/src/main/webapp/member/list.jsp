<%@page import="com.board.dto.PageDto"%>
<%@page import="com.board.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<style>
	tr.link {
		cursor : pointer;
	}
</style>
<%@include file="/common/header.jsp" %>

<div id="wrap">

	<h2>사용자 목록 조회</h2>
	<div class="input-group mb-3">
	<button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
	<ul class="dropdown-menu">
	  <li><a class="dropdown-item" href="#">Action</a></li>
	  <li><a class="dropdown-item" href="#">Another action</a></li>
	  <li><a class="dropdown-item" href="#">Something else here</a></li>
	  <li><hr class="dropdown-divider"></li>
	  <li><a class="dropdown-item" href="#">Separated link</a></li>
	</ul>
	<input type="text" class="form-control" aria-label="Text input with dropdown button">
	<button class="btn btn-outline-secondary" type="button">Button</button>
	
	</div>

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
			PageDto pageDto = (PageDto)request.getAttribute("pageDto");
			if(pageDto.isPrev())
				out.print(" <a href='/member/list?pageNo="+(pageDto.getStartNo()-1)+"'>" + "<" + "</a> ");
			for(int pageNo = pageDto.getStartNo();pageNo<=pageDto.getEndNo();pageNo++){
				out.print(" <a href='/member/list?pageNo="+pageNo+"'>" + pageNo + "</a> ");
			}
			if(pageDto.isNext())
				out.print(" <a href='/member/list?pageNo="+(pageDto.getEndNo()+1)+"'>" + ">" + "</a> ");
			
		}
	%>
	
	
	
	
</div>

<%@include file="/common/footer.jsp" %>
