package com.board.service;

import java.util.List;

import com.board.dao.MemberDao;
import com.board.dto.MemberDto;

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

	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}
	
}
