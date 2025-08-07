package dev.spring.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dev.spring.board.dto.MemberDto;

// ✨ Mapper는 interface ✨
public interface MemberMapper {
	
	// 파라메터를 한개만 넣을때는 이름을 명시하지 않아도 됨
	// 여러개 넣을때는 어노테이션을 붙여 주어야 해요!!  
	// ->> 어노테이션을 사용한 경우에는 이름 으로 접근 하세요 
	// ex) member.user_id
	MemberDto login(@Param("member") MemberDto member);
	
	int update_fail_count(MemberDto member);
	
	// 목록조회
	List<MemberDto> getList();
	
	// 사용자 아이디 중복체크
	int checkId(MemberDto member);
	
}
