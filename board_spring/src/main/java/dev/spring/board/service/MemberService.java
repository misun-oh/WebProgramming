package dev.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import dev.spring.board.dto.MemberDto;
import dev.spring.board.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	// 수집된 파라메터를 이용하여 로그인 처리를 진행
	// model : 데이터 저장 - 화면에 전달
	// memberDto : 요청파라메터 
	public boolean login(Model model, MemberDto member){
		// ID/PW가 일치하는 사용자가 있는지 조회
		// 사용자가 있으면 MemberDto객체를 반환, 없으면 null을 반환
		MemberDto loginMember = memberMapper.login(member);
		if(loginMember != null) {
			// 로그인 성공
			System.out.println("로그인 성공");
			model.addAttribute("msg", "로그인 성공");
			return true;
		} else {
			// 로그인 실패
			System.out.println("로그인 실패");
			// 로그인 실패 카운트 증가및 5회 이상시 계정 잠금
			int res = memberMapper.update_fail_count(member);
			model.addAttribute("msg", "아이디 비밀번호를 확인해주세요");
			return false;
		}
	}
}
