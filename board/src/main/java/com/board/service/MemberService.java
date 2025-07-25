package com.board.service;

import java.util.List;

import com.board.dao.MemberDao;
import com.board.dto.MemberDto;
import com.board.dto.SearchDto;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public boolean insert(MemberDto member) {
		if(dao.insert(member) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public MemberDto login(String id, String pass) {		
		return dao.login(id, pass);
	}
	
	public List<MemberDto> getMemberList(){
		return dao.getMemberList();
	}
	
	// 페이징 처리가 된 메서드를 호출
	public List<MemberDto> getMemberListPageing(SearchDto searchDto){
		return dao.getMemberListPageing(searchDto);
	}

	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}

	public MemberDto getMember(String id) {
		return dao.getMember(id);
	}

	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	public int updateMember(MemberDto member) {
		if(member.getId() == null || member.getPass() == null) {
			return 0;
		}
		return dao.updateMember(member);
	}
	
}
