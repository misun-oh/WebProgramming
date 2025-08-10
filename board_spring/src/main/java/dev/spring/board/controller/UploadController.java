package dev.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dev.spring.board.dto.SearchDto;
import dev.spring.board.dto.UploadDto;
import dev.spring.board.service.UplodService;
import dev.spring.board.util.FileNameUtils;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@Autowired
    private UplodService uplodService;
	
	@GetMapping("/upload_form")
    public void form() { }

    @PostMapping(value = "/upload_action", consumes = "multipart/form-data")
    public String handleUpload(List<MultipartFile> files
    		, UploadDto uploadDto, Model model) {
    	
        for(MultipartFile file : files) {
        	// 확장자 체크
			boolean checkExtension = FileNameUtils.isAllowedExt(FileNameUtils.getExtension(file.getOriginalFilename()));
			if(!checkExtension) {
				model.addAttribute("msg", "파일형식을 확인해주세요.");
				return "/common/msgbox";
			}
        }
        
        uplodService.saveFiles(files, uploadDto, model);
        model.addAttribute("url", "/upload/list");
        return "redirect:/common/msgbox";
    }
    
    @GetMapping("/list")
    public void list(Model model, SearchDto search) {
    	uplodService.getList(search, model);
    }
    
}
