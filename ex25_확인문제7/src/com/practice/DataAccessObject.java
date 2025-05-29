package com.practice;

public interface DataAccessObject {
	
	// ResultSet
	void select();
	// 몇 건이 처리되었어?
	int insert();
	int update();
	int delete();

}
