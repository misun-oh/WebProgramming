package com.practice;

public class DaoExample {
	// interface : DataAccessObject
	// impl : OracleDao, MySqlDao
	// 매개변수의 다형성 
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		
		// ClassCastException: 타입변환 오류
		// 업캐스팅은 자동, 다운캐스팅은 강제 
		// 		-> 예외가 발생 할 수 있으므로 instanceof 키워드를 이용해서 변경 가능한 타입인지 확인 후 변환 해야 한다
//		OracleDao o = (OracleDao)dao;
//		o.getType();
		boolean res = dao instanceof OracleDao;
		if(dao instanceof OracleDao o) {
			//OracleDao o = (OracleDao)dao;
			System.out.println(o.getType());
		}
	}
	
	public static void main(String[] args) {
		// 생성하지 않고 사용하기위해서 dbWork에 static키워드가 붙어 있다!
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}
}
