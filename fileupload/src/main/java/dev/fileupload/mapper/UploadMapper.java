package dev.fileupload.mapper;

import dev.fileupload.dto.UploadDto;

public interface UploadMapper {
	
	int insertUpload(UploadDto dto);
	
}
