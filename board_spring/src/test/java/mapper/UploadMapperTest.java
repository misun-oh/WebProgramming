package mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.spring.board.config.AppConfig;
import dev.spring.board.dto.UploadDto;
import dev.spring.board.mapper.UploadMapper;

@SpringJUnitConfig(AppConfig.class)
public class UploadMapperTest {
	
	@Autowired
	UploadMapper mapper;
	
	@Test
	public void insertTest() {
		UploadDto upload = new UploadDto();
		
		upload.setContentType("jpg");
		upload.setOrigName("업로드된 파일명");
		upload.setStoredName("업로드파일명_uuid"); // 이름이 중복될 경우, 파일이 유실될수 있음
//		upload.setBoardId("board");
//		upload.setBoardSeq(1);
		upload.setRelPath("/2025/08/");
		upload.setUserId("100");
		upload.setAttachIdx(1);
		
		int res = mapper.insertUpload(upload);
		System.out.println(res);
	}
}
