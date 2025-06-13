package com.lib.service;

import java.util.List;

import com.lib.dao.MemberDao;
import com.vo.MemberVO;

public class MemberService {
	
	MemberDao dao = new MemberDao();
	
	public int insert(MemberVO member) {
		int res = dao.insert(member);
		if(res > 0) {
			System.out.println(res + "건 입력 되었습니다.");
		} else {
			System.err.println("입력 실패!");
		}
		return res;
	}
	
	public MemberVO login(String id, String pw) {
		MemberVO member = dao.login(id, pw);
		if(member == null) {
			System.out.println("로그인 실패");
		} else {
			System.out.println(member.getName() + "님 환영 합니다.");
		}
		return member;
	}
	
	public List<MemberVO> getList(){
		List<MemberVO> list = dao.getList();
		if(list.isEmpty()) {
			System.out.println("사용자가 존재하지 않습니다.");
		} else {
			for(MemberVO member : list) {
				String isAdmin = member.isAdminYN()?"관리자":"";
				System.out.printf("%s \t %s \t %s \n", member.getId(), member.getName(), isAdmin);
			}
		}
		return list;
	}
}
