package dev.fileupload.controller;



import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import dev.fileupload.HomeController;
import dev.fileupload.dto.SearchDto;
import dev.fileupload.dto.UploadDto;
import dev.fileupload.service.UploadService;

@Controller
@RequestMapping("/upload")
public class UploadController {

    private final HomeController homeController;

	@Autowired
	UploadService uploadService;

    UploadController(HomeController homeController) {
        this.homeController = homeController;
    }
	
	@GetMapping("/upload")
	private void upload(Model model, SearchDto searchDto) {
		// upload.jsp
		// 파일 목록 조회
		uploadService.selectList(model, searchDto);
				
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
	
	// file_id, attach_idx로 다운로드
	@GetMapping("/download")
	private ResponseEntity<byte[]> downloadFile(UploadDto dto) {
		System.out.println(dto.getFile_id());
		System.out.println(dto.getAttach_idx());
		
		byte[] content = null;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			// file_id, attach_idx를 이용해서 1건에 대한 파일정보를 조회
			dto = uploadService.getFile(dto);
			
			Path path = Paths.get("C:/dev/upload/" + dto.getStored_name()); // 서버에 저장된 파일의 위치
			String oname = dto.getOrig_name();
			
			//headers.set(Content-Type, "text/html; charset=UTF-8");
			//headers.set(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
			headers.set(HttpHeaders.CONTENT_TYPE, "application/octet-stream"); // 다운로드 이름 filename=영문
			headers.set(HttpHeaders.CONTENT_DISPOSITION
							, "attachment; filename=\"file.mp4\"; filename*=UTF-8''" 
																	+ URLEncoder.encode(oname, "utf-8"));
			
			content = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// header를 조작(넘겨줄 데이터, 헤더, 상태코드)
		//return new ResponseEntity<byte[]>("한글".getBytes(), headers, HttpStatus.OK);
		return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
		//return "안녕";

	}
	
	
	// 파일명으로 다운로드 
	@GetMapping("/download_filename")
	private ResponseEntity<byte[]> download(UploadDto dto) {
		System.out.println(dto.getStored_name()); 	// 저장된 이름
		System.out.println(dto.getOrig_name());		// 원본이름 (다운로드 받을때 저장할 이름)
		
		byte[] content = null;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			Path path = Paths.get("C:/dev/upload/" + dto.getStored_name()); // 서버에 저장된 파일의 위치
			String oname = dto.getOrig_name();
			
			//headers.set(Content-Type, "text/html; charset=UTF-8");
			//headers.set(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
			headers.set(HttpHeaders.CONTENT_TYPE, "application/octet-stream"); // 다운로드 이름 filename=영문
			headers.set(HttpHeaders.CONTENT_DISPOSITION
							, "attachment; filename=\"file.mp4\"; filename*=UTF-8''" 
																	+ URLEncoder.encode(oname, "utf-8"));
			
			content = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// header를 조작(넘겨줄 데이터, 헤더, 상태코드)
		//return new ResponseEntity<byte[]>("한글".getBytes(), headers, HttpStatus.OK);
		return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
		//return "안녕";

	}
	
	// 사용자가 다운로드 받으려고 하는 파일의 정보를 조회
	@GetMapping("/header/{file_id}/{attach_index}")
	@ResponseBody
	private ResponseEntity<byte[]> header() {
		
		byte[] content = null;
		HttpHeaders headers = new HttpHeaders();
		
		 
		
		try {
			//headers.set(Content-Type, "text/html; charset=UTF-8");
			//headers.set(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
			headers.set(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
																	// 다운로드 이름 filename=영문
			String oname = "샐러드.jpg";
			
			headers.set(HttpHeaders.CONTENT_DISPOSITION
							, "attachment; filename=\"file.mp4\"; filename*=UTF-8''" 
																	+ URLEncoder.encode(oname, "utf-8"));
			
			Path path = Paths.get("C:/dev/upload/salad.jpg");
			content = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// header를 조작(넘겨줄 데이터, 헤더, 상태코드)
		//return new ResponseEntity<byte[]>("한글".getBytes(), headers, HttpStatus.OK);
		return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
		//return "안녕";

	}
}
