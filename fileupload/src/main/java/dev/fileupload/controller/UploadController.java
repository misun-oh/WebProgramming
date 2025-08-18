package dev.fileupload.controller;



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	// 프로퍼티 파일의 정보를 읽어오기
	@Value("${file.upload.upload_dir}")
	private String uploadRoot; 
	
	@GetMapping("/upload")
	private void upload() {}
	
	@PostMapping("/upload")
	private void upload_action(MultipartFile file, String user_id) {
		System.out.println("file : " + file);
		System.out.println("user_id : " + user_id);
		
		if(file.isEmpty()) {
			System.out.println("첨부파일 없음");
		} else {
			System.out.println("==================== 첨부파일 ");
			System.out.println(file.isEmpty());
			System.out.println(file.getName());
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
			System.out.println(file.getContentType());		
			System.out.println("====================");
			
			// 동일한 파일명이 업로드 는경우 파일이 유실될 수 있음
			// 업로드 폴더의 위치는 설정 파일에서 가지고 오도록 지정 (C:/dev/upload/ - 하드코딩)
			// 폴더를 년/월/일 - C:/dev/upload/년/월/일/
			// 파일명 + UUID + 확장자
			try {
				//String uploadRoot = "C:/dev/upload/";
				// 저장할 파일명
				String sname = getSname(file.getOriginalFilename());
				Path path = Paths.get(uploadRoot, sname);			
				
				// 지정된 위치에 파일을 저장
				file.transferTo(path);
				
				System.out.println("파일 저장");
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// 파일유틸을 만들기
	// 메서드 - 저장된 파일명을 반환하는 메서드
	// 파일의 확장자를 검사하는 메서드 
	public String getSname(String oname){
		// 파일의 이름을 새로 만들어 주는 역할
		// 파일명 + _uuid + .확장자
		System.out.println(".의 위치" + oname.lastIndexOf("."));
		// 파일이름
		String name = oname.substring(0, oname.lastIndexOf("."));
		String ext = oname.substring(oname.lastIndexOf(".")+1);
		String uuid = UUID.randomUUID().toString();
		System.out.println("oname : " + name);
		System.out.println("ext : " + ext);
		System.out.println("uuid : " + uuid);
		
		String sname = name + "_" + uuid + "." + ext;
		return sname;
	}
			
}
