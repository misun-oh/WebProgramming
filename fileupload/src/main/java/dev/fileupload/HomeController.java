package dev.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 하나의 파일에 여러개의 요청주소를 매핑
// 파라메터 수집을 자동으로 처리
// Request, Response객체를 사용하지 않고 개발
@Controller
public class HomeController {

	// WEB-INF하위의 경로는 직접(.jsp를 요청)호출 할수 없어요!!!
	// 컨트롤러를 경유해야합니다. 
	
	// /요청 url이 요청되면 실행 하 메서드
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String mostrarHome() {
    	System.out.println("/요청");
    	
        return "home";
    }
    
    
    // get방식으로 /test 요청을 하면 실행
    // 반환 타입이 없는 경우, 요청경로와 같은 파일을 반환
    @GetMapping("/test")
    public void test() {
    	System.out.println("/test");
    }

}
