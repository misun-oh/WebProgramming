<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.board.dto.PageDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>태그라이브러리를 사용하여 페이지블럭을 출력해봅시다</h2>

	<c:if test="${pageDto != null }">
		<h3>pageing블럭 출력</h3>
	</c:if>
	<c:if test="${pageDto == null }">
		<h3>pageDto is null</h3>
	</c:if>
	
<hr>
<h2>스크립틀릿을 사용하여 페이블블럭을 출력</h2>

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
	%>
	<nav aria-label="...">
    <ul class="pagination justify-content-center">
    <%
    if(pageDto.isPrev()){
    %>
      <li class="page-item">
        <a class="page-link" href="javascript:go(<%=pageDto.getStartNo()-1%>)">이전</a>
      </li>
   <%} %>
   <%	
   for(int i = startNo; i <= endNo; i++){
	   String active = i == pageDto.getPageNo() ? "active" : "";
   %>   
      <li class="page-item <%=active%>"><a class="page-link" href="javascript:go(<%=i%>)"><%=i %></a></li>
   <%	
   	}
   %>  
   <%
    if(pageDto.isNext()){
   %>   
      <li class="page-item">
        <a class="page-link" href="javascript:go(<%=pageDto.getEndNo()+1%>)">다음</a>
      </li>
   <%}
    } 
    %>  
    </ul>
    </nav>
</body>
</html>