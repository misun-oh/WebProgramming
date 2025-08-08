package dev.spring.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import dev.spring.board.dto.MemberDto;
import dev.spring.board.dto.SearchDto;

// ✨ Mapper는 interface ✨
public interface MemberMapper {
	
	// 파라메터를 한개만 넣을때는 이름을 명시하지 않아도 됨
	// 여러개 넣을때는 어노테이션을 붙여 주어야 해요!!  
	// ->> 어노테이션을 사용한 경우에는 이름 으로 접근 하세요 
	// ex) member.user_id
	MemberDto login(@Param("member") MemberDto member);
	
	int update_fail_count(MemberDto member);
	
	// 목록조회
	List<MemberDto> getList(SearchDto search);
	
	// 사용자 아이디 중복체크
	int checkId(MemberDto member);

	// 로그인 실패 카운트 초기화
	@Update("UPDATE MEMBER SET LOGIN_FAIL_COUNT = 0 WHERE USER_ID = #{user_id}")
	int update_fail_count_reset(MemberDto member);

	String[] getRoles(MemberDto member);

	int totalCnt(SearchDto search);
	
	// 아이디 찾기 - 이름, 이메일을 받아서 아이디를 알려주는 서비스
	/* 비밀번호 초기화 - 1) 임시시밀번호를 생성해서 이메일로 전송
					 2) 비밀번호 초기화 - 인증 -> 비밀번호 초기화
									이메일로 비밀번호 수정 URL을 전송 -> 비밀번호 초기화
	*/
	
	
}
