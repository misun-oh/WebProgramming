package dev.spring.board.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.spring.board.dto.MemberDto;

@RestController
//@RequestMapping(value = "/api", produces = "application/json; charset=UTF-8")
@RequestMapping(value = "/api")
public class RestTest {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, REST! 한글테스트";
    }
    
    @GetMapping("/member")
    public MemberDto member() {
    	MemberDto member = new MemberDto();
    	member.setUsername("오미자");
        return member;
    }
    
    @GetMapping("/map")
    public Map<String, Integer > map() {
    	Map<String, Integer > map 
    				= Map.of("checkId", 1);
    	return map;
    }
    
    @GetMapping("/re_str")
    public ResponseEntity<String> re_str() {
        return ResponseEntity
               .status(HttpStatus.OK)
               .body("안녕하세요!");
    }
    
    @GetMapping("/re_obj")
    public ResponseEntity<MemberDto> re_obj() {
    	MemberDto member = new MemberDto();
    	member.setUsername("오미자");
        return ResponseEntity
               .status(HttpStatus.OK)
               .body(member);
    }
    
    
}
