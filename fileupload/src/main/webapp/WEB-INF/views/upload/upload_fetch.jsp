<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//버튼을 클릭하면 버튼이 클릭되엇다고 메세지 처리
	window.addEventListener('load', ()=>{
		// 리스트 조회
		getList();
		
		let upload_btn = document.querySelector('#upload_btn');
		upload_btn.addEventListener('click', (e)=>{
			e.preventDefault();
			console.log('파일 업로드 버튼 클릭');
			
			let url = "/upload/upload_fetch";
			let formdata = new FormData(uploadForm);
			
			fetch(url, {
				method : 'post',
				body : formdata
			}) // 요청URL
			  .then(response => response.json())	// 요청결과를 object로 변환
			  .then(result => {
				  	// 서버의 통신결과
			    	console.log('res', result.res);
				  	console.log('msg', result.msg);
				  	// msg가 falsy한 값이 아니라면 = 값이 있으면
				  	if(result.msg){
				  		alert(result.msg);
				  	}
				  	
			  })
			  .catch(err=>{
				  	// 네트워크 장애, 매핑된 url이 없는경우
					console.log('err', err);  
			  });
		});
		
	})
	
	
	function getList(){
		let url = '/upload/upload_list?pageNo=2';
		
		fetch(url) // 요청URL
		.then(response => response.json())	// 요청결과를 object로 변환
		.then(result => {
			// 서버의 통신결과 = map
			// list, pageDto
			// 리스트를 화면에 출력
			printList(result);
		  	
		})
		.catch(err=>{
			  	// 네트워크 장애, 매핑된 url이 없는경우
				console.log('err', err);  
		});
	}

	function printList(result){
		// 리스트 출력
		console.log("list", result.list);
		
		// 페이지 블럭
		
	  	console.log("pageDto", result.pageDto);
	  	let pageDto = result.pageDto;
	  	console.log(pageDto.startNo);
	  	console.log(pageDto.endNo);

	  	if(pageDto.isPrev){
	  		console.log("<");
	  	}
	  	
	  	for(let i=pageDto.startNo;i<=pageDto.endNo;i++){
	  		console.log("페이지"+i);
	  	}
	  	
	  	if(pageDto.isNext){
	  		console.log(">");
	  	}
	}
</script>
</head>
<body>
<!-- header 영역 -->
<%@include file="/common/header.jsp" %>
<!-- main 영역 -->
<div id="wrap">
	<h1>fetch를 이용한 파일 업로드</h1>
	<form action="/upload/upload_fetch" name="uploadForm">
		<input type="file" name="file">
		<button id="upload_btn">파일 업로드</button>
	</form>
</div>
<!-- footer 영역 -->
<%@include file="/common/footer.jsp" %>
</body>
</html>