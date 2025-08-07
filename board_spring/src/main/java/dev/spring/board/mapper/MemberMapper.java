package dev.spring.board.mapper;

import dev.spring.board.dto.MemberDto;

public interface MemberMapper {
	
	MemberDto getMember(String user_id);
	
	String[] getRole(String user_id);
	
}
