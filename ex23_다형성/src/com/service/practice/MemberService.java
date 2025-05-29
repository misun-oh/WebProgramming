package com.service.practice;

public interface MemberService {
	
	int insert();
	int update();
	int delete();
	
	Member[] selectMember();
	
}
