<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-end" id="pagination"></ul>
</nav>

<script>
  const pageDto = {
    startPage: 1,
    endPage: 5,
    currentPage: 3,
    hasPrev: true,
    hasNext: true,
    totalPages: 10
  };

  function createPagination(pageDto) {
    const ul = document.getElementById('pagination');
    ul.innerHTML = ''; // 기존 버튼 제거

    // 이전 버튼
    const prevLi = document.createElement('li');
    prevLi.className = `page-item ${pageDto.hasPrev ? '' : 'disabled'}`;
    const prevLink = document.createElement('a');
    prevLink.className = 'page-link';
    prevLink.href = '#';
    prevLink.textContent = 'Previous';
    if (pageDto.hasPrev) {
      prevLink.addEventListener('click', () => movePage(pageDto.currentPage - 1));
    }
    prevLi.appendChild(prevLink);
    ul.appendChild(prevLi);

    // 페이지 번호들
    for (let i = pageDto.startPage; i <= pageDto.endPage; i++) {
      const li = document.createElement('li');
      li.className = 'active';
      const link = document.createElement('a');
      link.className = 'page-link';
      link.href = '#';
      link.textContent = i;
      link.addEventListener('click', () => movePage(i));
      li.appendChild(link);
      ul.appendChild(li);
    }

    // 다음 버튼
    const nextLi = document.createElement('li');
    nextLi.className = `page-item ${pageDto.hasNext ? '' : 'disabled'}`;
    const nextLink = document.createElement('a');
    nextLink.className = 'page-link';
    nextLink.href = '#';
    nextLink.textContent = 'Next';
    if (pageDto.hasNext) {
      nextLink.addEventListener('click', () => movePage(pageDto.currentPage + 1));
    }
    nextLi.appendChild(nextLink);
    ul.appendChild(nextLi);
  }

  // 페이지 이동 로직 (데이터 다시 불러오거나 API 호출 등)
  function movePage(pageNum) {
    console.log(`페이지 ${pageNum}로 이동`);
    // TODO: pageNum 기반으로 데이터를 다시 불러오고, pageDto 업데이트
    // createPagination(새로운 pageDto); <-- 이걸로 다시 호출
  }

  // 초기 호출
  createPagination(pageDto);
</script>

</body>
<%@include file="/common/footer.jsp" %>
</html>