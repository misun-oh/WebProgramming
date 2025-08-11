window.addEventListener('load', ()=>{
	// 버튼이 있을때만 이벤트를 추가
    let loginBtn = document.querySelector('#loginBtn');
    if(loginBtn != null){
	    loginBtn.addEventListener('click', ()=>{
	        location.href = '/member/login';
	    });
    }
    
    // 버튼이 있을때만 이벤트를 추가
    let signUpBtn = document.querySelector('#signUpBtn');
    if(signUpBtn != null){
	    signUpBtn.addEventListener('click', ()=>{
	        location.href= '/member/register'
	    });
    }
    
    // 로그아웃 버튼을 클릭하면 /member/loginout.jsp페이지로 연결
    let logoutBtn = document.querySelector('#logoutBtn');
    if(logoutBtn != null){
	    logoutBtn.addEventListener('click', ()=>{
	        //location.href= '/member/logout'; // get방식
			// -> post방식으로 변경
			
			logoutForm.method = "post";
			logoutForm.action = "/member/logout";
			logoutForm.submit();
			
	    });
    }
    
    // 검색 버튼을 클릭시 페이지번호를 초기화 하여 검색
    let searchBtn = document.querySelector('#searchBtn');
    if(searchBtn){
		searchBtn.addEventListener('click', ()=>{
	       	// searchForm의 pageNo를 초기화후 전송
	       	// 검색버튼을 클릭 하면 1페이지 보여주기
	       	go(1);
	    });
	    
	}
	
	// 페이지당 게시물의수가 변경되면 searchForm submit
	let amount = document.querySelector('[name="amount"]')
	if(amount){
		amount.addEventListener('change', ()=>{
			console.log(amount.value);			
			// searchForm.submit();
			go();	
		})
	}
	

});

// select 박스 옵션 목록을 초기화
// 옵션목록을 매개변수로 전달 받아서 select박스에 옵션을 추가
function settingSelect(searchField, optionList, selectedItem){
	
	// 리스트의 요소를 하나씩 꺼내서 반복문을 실행
	optionList.forEach(function(item, index){
		console.log(index, item);
	    // option 태그 생성
	    let option = document.createElement("option"); // <option> 요소 생성
	    // 속성 추가
	    option.value = item.value;
	    option.textContent = item.text;
	
	    // 검색유지
	    if(selectedItem == item.value){
	    	option.selected = true;
	    }
	    
	    searchField.appendChild(option);
	})
}

// 페이지블럭의 버튼을 클릭 했을때 리스트 페이지를 요청
// 페이지 번호, 페이지당게시물수를 파라메터로 넘겨주는 역할
function go(pageNo, url){
	
	console.log("pageNo : ", pageNo);
	
	// 매개변수로 넘어온 pageNo가 있으면 pageNo를 세팅
	// 없으면 기존값 그대로
	// undefined : 매개변수로 넘어온 값이 없는경우 
	if(pageNo){	// undefined, null, 0, ""  => false
		// pageNo를 매개변수로 넘어온 값으로 변경
		document.querySelector("[name=pageNo]").value = pageNo;
	}
	
	// 페이지 마다 요청 URL이 다름
	// /member/list, /board/list/ ...
	if(url){
		searchForm.action = url;
	} else {
		// 현재요청 경로를 url로 지정
		searchForm.action = location.pathname;
	}
	
	// form 전송
	searchForm.submit();
	
}

//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
            extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}