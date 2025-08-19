package mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.fileupload.config.AppConfig;
import dev.fileupload.dto.SearchDto;
import dev.fileupload.dto.UploadDto;
import dev.fileupload.mapper.UploadMapper;

@SpringJUnitConfig(AppConfig.class)
public class UploadMapperTest {
	
	@Autowired
	UploadMapper uploadMapper;
	
	@Test
	public void select() {
		
		List<UploadDto> list = uploadMapper.selectList(new SearchDto());
		assertNotNull(list);
		//assertEquals(6, list.size());
	}
	
	@Test
	public void insert() {
		UploadDto upload = new UploadDto();
		upload.setAttach_idx(0);
		upload.setContent_type("img");
		upload.setFile_size(1000);
		upload.setStored_name("sname");
		upload.setOrig_name("oname");
		upload.setRel_path("2025/08/18/");
		upload.setUser_id("100");
		
		int res = uploadMapper.insertUpload(upload);
		System.out.println("=========== " + res);

	}
	
}
