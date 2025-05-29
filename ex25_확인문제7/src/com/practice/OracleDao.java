package com.practice;

public class OracleDao implements DataAccessObject{

	@Override
	public void select() {
		System.out.println("Oracle DB에서 검색");
		
	}
	
	public String getType() {
		return "오라클";
	}
	@Override
	public int insert() {
		System.out.println("Oracle DB에서 삽입");
		return 0;
	}

	@Override
	public int update() {
		System.out.println("Oracle DB에서 수정");
		return 0;
	}

	@Override
	public int delete() {
		System.out.println("Oracle DB에서 삭제");
		return 0;
	}

}
