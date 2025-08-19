package dev.fileupload.controller;



import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dev.fileupload.service.UploadService;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	UploadService uploadService;
	
	@GetMapping("/upload")
	private void upload() {
		// upload.jsp
		// 파일 목록 조회
	}
	
	@PostMapping("/upload")
	private String upload_action(Model model, MultipartFile file, String user_id) {
		System.out.println("file : " + file);
		System.out.println("user_id : " + user_id);
		
		int res = uploadService.insertUpload(file);
		// 메세지 처리 -> /upload/upload로 redirect (재호출 -> 다시 요청)
		model.addAttribute("msg", res + "건 저장 되었습니다.");
		
		// 리스트를 조회 하는건 /upload/upload 
		model.addAttribute("url", "/upload/upload");
		
		return "/common/msgbox";
		
	}
	
			
	@GetMapping("/header")
	@ResponseBody
	private ResponseEntity<String> header() {
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Custom-Response-Header", "response_value");
	    //responseHeaders.set(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
	    
	    
	    
	    
	    //return new ResponseEntity<>(HttpStatus.OK);
	    return new ResponseEntity<String>("Hello", HttpStatus.OK);
	    //return new ResponseEntity<String>("Hello", new HttpHeaders(), HttpStatus.OK);
//	    return ResponseEntity.ok()
//	            .headers(responseHeaders)
//	            .body("응답 본문 내용");
		

	}
}
