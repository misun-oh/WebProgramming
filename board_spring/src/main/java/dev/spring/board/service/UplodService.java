package dev.spring.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import dev.spring.board.dto.PageDto;
import dev.spring.board.dto.SearchDto;
import dev.spring.board.dto.UploadDto;
import dev.spring.board.mapper.UploadMapper;
import dev.spring.board.util.FileNameUtils;

@Service
public class UplodService {
	@Value("${file.upload.upload_dir}")
	String upload_dir;
	
	@Autowired
	UploadMapper uploadMapper;
	
	public List<UploadDto> saveFiles(List<MultipartFile> files
								, UploadDto param, Model model) {
		int index = 0;
		for(MultipartFile file : files) {	
			UploadDto dto = new UploadDto();
			dto.setContentType(file.getContentType());
			dto.setFileSize(file.getSize());
			dto.setOrigName(file.getOriginalFilename());
			dto.setUserId(param.getUserId());
			dto.setAttachIdx(index);
			
			// 업르드 경로 작성
			String realPath = FileNameUtils.generateUploadPath(upload_dir, dto.getBoardId(), dto.getUserId());
			dto.setRelPath(realPath);
			// 저장파일명 작성
			dto.setStoredName(FileNameUtils.getStoreName(file.getOriginalFilename()));
			

			try {
				System.out.println("file dto : " + dto);
				File newFile = new File(dto.getRelPath() + File.separator + dto.getStoredName()); 
				
				// 파일 저장
				file.transferTo(newFile);
				// DB 저장
				int res = uploadMapper.insertUpload(dto);
				 
				if(res > 0)
					index++;

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
      	   	System.out.println("=====================");
          	System.out.println(file.getName());
          	System.out.println(file.getOriginalFilename());
          	System.out.println(file.getSize());
          	System.out.println(file.getContentType());
      	   	System.out.println("=====================");
      	   	
        }
 
		String msg = String.format("%d건 중 %d건 저장 되었습니다. ", files.size(), index);
		model.addAttribute("msg" , msg);
		return null;
	}

	public void getList(SearchDto search, Model model) {
		List<UploadDto> list = uploadMapper.getList(search);
		int totalCnt = uploadMapper.getTotalCnt(search);
		PageDto pageDto = new PageDto(search, totalCnt);
		model.addAttribute("list", list);
		model.addAttribute("pageDto", pageDto);
	}


}
