package dev.fileupload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import dev.fileupload.dto.SearchDto;
import dev.fileupload.dto.UploadDto;

public interface UploadMapper {
	
	int insertUpload(UploadDto dto);
	
	// 매개변수가 2개 이상인경우 @param 속성을 지정 해야함!
	List<UploadDto> selectList(SearchDto search);


	int getTotalCnt(SearchDto search);
}
