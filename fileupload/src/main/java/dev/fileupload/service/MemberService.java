package dev.fileupload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import dev.fileupload.dto.MemberDto;
import dev.fileupload.dto.PageDto;
import dev.fileupload.dto.SearchDto;
import dev.fileupload.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	// 수집된 파라메터를 이용하여 로그인 처리를 진행
	// model : 데이터 저장 - 화면에 전달
	// memberDto : 요청파라메터 
	public boolean login(Model model, MemberDto member){
		// 인증 : ID/PW가 일치하는 사용자가 있는지 조회
		// 사용자가 있으면 MemberDto객체를 반환, 없으면 null을 반환
		MemberDto loginMember = memberMapper.login(member);
		System.out.println("==================    " + loginMember);
		if(loginMember != null) {
			if("Y".equals(loginMember.getAccount_locked())) {
				// 로그인 실패로 계정이 잠긴 상태
				model.addAttribute("msg", "계정이 잠긴 상태 입니다. 관리자에게 문의해주세요.");
				return false;
			}
			
			// ✨사용자의 권한✨을 조회 해서 MemberDto의 roles 필드에 추가 
			String[] roles = memberMapper.getRoles(member);
			loginMember.setRoles(roles);
			
			// 로그인 성공
			// 로그인 실패 카운트 초기화
			int res = memberMapper.update_fail_count_reset(member);
			System.out.println("로그인 성공");
			model.addAttribute("msg", "로그인 성공");
			// 로그인한 사용자의 정보
			model.addAttribute("member", loginMember);
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

	public void getList(Model model, SearchDto search) {
		List<MemberDto> list = memberMapper.getList(search);
		System.out.println("list=====================: " + list);
		int totalCnt = memberMapper.totalCnt(search);
		
		PageDto pageDto = new PageDto(search, totalCnt);
		// 화면에 전달
		// 리스트 출력
		model.addAttribute("list", list);
		// 페이지 블럭 출력
		model.addAttribute("pageDto", pageDto);
	}
}
