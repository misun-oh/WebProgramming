package com.practice;

public class MySqlDao implements DataAccessObject{

	@Override
	public void select() {
		System.out.println("Mysql DB에서 검색");
		
	}

	@Override
	public int insert() {
		System.out.println("Mysql DB에서 삽입");
		return 0;
	}

	@Override
	public int update() {
		System.out.println("Mysql DB에서 수정");
		return 0;
	}

	@Override
	public int delete() {
		System.out.println("Mysql DB에서 삭제");
		return 0;
	}

}
