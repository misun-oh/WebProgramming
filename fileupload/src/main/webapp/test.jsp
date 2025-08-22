<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*


fetch(url) // 요청URL
.then(response => response.json())	// 요청결과를 object로 변환
.then(result => {
	  	// 서버의 통신결과
  	console.log(result);
})
.catch(err=>{
	  	// 네트워크 장애, 매핑된 url이 없는경우
		console.log('err', err);  
});


*/
</script>

<script>


	// 화면이 로드된이후 실행 - 요소 없으면 선택할 수 없으니까!!
	window.addEventListener('load', ()=>{
	  console.log('load이벤트 호출');
	  getList(1);
	  
	})

	function getList(pageNo){
		// 1. fetch 호출
		fetch('/upload/upload_list?pageNo='+pageNo)  // <-- 여기에 실제 백엔드 URL을 넣으세요
		  .then(response => response.json())
		  .then(result => {
		    console.log('호출 결과 : ', result);
		    const pageDto = result.pageDto;
		    
		    // 리스트 그려주는 함수
		    renderListDom(result.list);
		    
		    // 페이지블럭을 그려주는 함수
		    renderPagination(pageDto);
		    
		  })
		  .catch(error => console.error('Error fetching data:', error));
	}
	
	function renderListDom(list){
		console.log("renderList()", list);
		table_tbody.innerText='';	// 초기화
		list.forEach((item, idx)=>{
			// tr 요소 추가
			let tr = document.createElement('tr');
			table_tbody.appendChild(tr);
			
			let td1 = document.createElement('td');
			td1.innerText = item.file_id;
			let td2 = document.createElement('td');
			td2.innerText = item.attach_idx;
			let td3 = document.createElement('td');
			td3.innerHTML = 
								`<a href='/upload/download/\${item.file_id}/\${item.attach_idx}'>`
								+ item.orig_name 
								+ "</a>";
			let td4 = document.createElement('td');
			td4.innerText = item.file_size;
			
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			// tr 요소 화면에 등록
		});
		
		
	};

	function renderList(list){
		console.log("renderList()", list);
		let content = '';
		list.forEach((item, idx)=>{
			content += `<tr>
						<td>\${item.file_id}</td>
						<td>\${item.attach_idx}</td>
						<td>\${item.orig_name}<br>
						
						<a href='/upload/download/\${item.file_id}/\${item.attach_idx}'>
							\${item.stored_name}
						</a>
						
						</td>
						<td>\${item.file_size}</td>
						</tr>
			`;
			
		})
		
		// 화면에 추가
		table_tbody.innerHTML = content;
		
	};
	

  
  
  
</script>


</head>
<body>
<!-- header 영역 -->
<%@include file="/common/header.jsp" %>

<!-- main 영역 -->
<div id="wrap">
	<h3>파일 목록</h3>	
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">file_id</th>
	      <th scope="col">attach_idx</th>
	      <th scope="col">원본명<br>저장명</th>
	      <th scope="col">file_size</th>
	    </tr>
	  </thead>
	  <tbody id="table_tbody">
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Otto</td>
	      <td>@mdo</td>
	    </tr>
	  </tbody>
	</table>

	<!-- 페이지네이션이 렌더링될 위치 -->
	<nav aria-label="Page navigation">
	  <ul class="pagination justify-content-center" id="pagination">
	    <!-- fetch로 동적으로 채움 -->
	  </ul>
	</nav>

</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>