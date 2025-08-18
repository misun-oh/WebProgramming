package upload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.junit.jupiter.api.Test;

public class FileTestJunit {
	
	@Test
	public void test() throws IOException {
		// 원하는 위치에 파일을 생성 하기 위해서 경로를 지정
		String root = "C:/dev/upload/";
		
		Path path = Paths.get(root, "test.txt");
		if(!Files.exists(path)) {
			Files.createFile(path);
			System.out.println("파일생성");
		} else {
			System.out.println("이미 존재 하는 파일 입니다.");
		}

	}
	
	
	@Test
	public void test1() throws IOException {
		// 파일의 이름을 새로 만들어 주는 역할
		// 파일명 + _uuid + .확장자
		String filename = "test.txt.ext.exe";
		System.out.println(".의 위치" + filename.lastIndexOf("."));
		// 파일이름
		String name = filename.substring(0, filename.lastIndexOf("."));
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		String uuid = UUID.randomUUID().toString();
		System.out.println("filename : " + name);
		System.out.println("ext : " + ext);
		System.out.println("uuid : " + uuid);
		
		String sname = filename + "_" + uuid + "." + ext;
		
		Files.createFile(Paths.get(sname));

	}
	
	
}
