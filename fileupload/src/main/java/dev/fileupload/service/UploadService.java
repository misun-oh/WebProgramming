package dev.fileupload.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class UploadService {

	// 프로퍼티 파일의 정보를 읽어오기
	@Value("${file.upload.upload_dir}")
	private String uploadRoot; 
	
	// 파일의 정보를 데이터 베이스에 저장 하고 
	// 파일을 서버에 저장
	public int insertUpload(MultipartFile file) {
		int res = 0;
		if(file.isEmpty()) {
			System.out.println("첨부파일 없음");
		} else {
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
		return res;
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
