package dev.fileupload;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    
	@GetMapping("/h/download/{filename}")
	@ResponseBody
	private ResponseEntity<byte[]> header(String filename) {
        return new ResponseEntity<>("파일이 존재하지 않습니다".getBytes(), HttpStatus.NOT_FOUND);

//		byte[] content = null;
//		HttpHeaders headers = new HttpHeaders();
//		
//		try {
//			//headers.set(Content-Type, "text/html; charset=UTF-8");
//			//headers.set(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
//			headers.set(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
//																	// 다운로드 이름 filename=영문
//			String oname = filename;
//			
//			headers.set(HttpHeaders.CONTENT_DISPOSITION
//							, "attachment; filename=\"file.mp4\"; filename*=UTF-8''" 
//																	+ URLEncoder.encode(oname, "utf-8"));
//			
//			Path path = Paths.get("C:/dev/upload/salad.jpg");
//			content = Files.readAllBytes(path);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// header를 조작(넘겨줄 데이터, 헤더, 상태코드)
//		//return new ResponseEntity<byte[]>("한글".getBytes(), headers, HttpStatus.OK);
//		return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
//		//return "안녕";


	}
}
