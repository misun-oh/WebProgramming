package dev.spring.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.spring.board.dto.MemberDto;
import dev.spring.board.mapper.MemberMapper;

@RestController
public class RestApiController {
	@Autowired
	MemberMapper mapper;
    
    @GetMapping(value="/{user_id}")
    public MemberDto getUserTest(@PathVariable Long user_id) {
    	MemberDto dto = mapper.getMember("100"); 
        return dto;
    }
    
    @GetMapping("/api/user")
    public MemberDto getUser(@RequestParam MemberDto member) {
    	
        return member;
    }
    
}
