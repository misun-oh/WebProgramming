package dev.spring.board.mapper;

import java.util.List;

import dev.spring.board.dto.SearchDto;
import dev.spring.board.dto.UploadDto;

public interface UploadMapper {
	int insertUpload(UploadDto upload);
	List<UploadDto> selectUploadList();
	List<UploadDto> getList(SearchDto search);
	int getTotalCnt(SearchDto search); 
}
