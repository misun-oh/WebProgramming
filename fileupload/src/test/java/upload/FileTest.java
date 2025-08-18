package upload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.UUID;

public class FileTest {

	// 실행 메서드
	public static void main(String[] args) {
		// 경로를 지정 하지 않으면 프로젝트의 root 경로에 파일
		try {
			
			// 원하는 위치에 파일을 생성 하기 위해서 경로를 지정
			String root = "C:/dev/upload/";
			
			Path path = Paths.get(root, "test.txt");
			if(!Files.exists(path)) {
				Files.createFile(path);
				System.out.println("파일생성");
			} else {
				System.out.println("이미 존재 하는 파일 입니다.");
			}
			
			// 파일 삭제
			//Files.deleteIfExists(path);
			//System.out.println(path + "파일삭제");
			
			// 파일의 속성읽기
			BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

			System.out.println("생성 시간: " + attr.creationTime());
			System.out.println("마지막 수정 시간: " + attr.lastModifiedTime());
			System.out.println("파일 크기: " + attr.size() + " bytes");
			
			String filename = "test.txt.ext.exe";
			System.out.println(".의 위치" + filename.lastIndexOf("."));
			// 파일이름
			String name = filename.substring(0, filename.lastIndexOf("."));
			String ext = filename.substring(filename.lastIndexOf(".")+1);
			
			System.out.println("filename : " + name);
			System.out.println("ext : " + ext);
			
			
			System.out.println("uuid : " +  UUID.randomUUID().toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
