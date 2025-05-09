package com.ss.var;

import com.ss.var.practice.Calc;

public class App {
	
	public static void main(String[] args) {
		
		Calc c = new Calc();
		int res = c.minus(1, 2);
		System.out.println(res);
		// 이미 선언된 변수 값을 변경하거나
		// 새로운 변수를 선언 하거나
		res = c.plus(1, 2);
		System.out.println(res);
		// 반환타입이 없는 경우 출력시 오류가 발생
		//System.out.println(c.toStr("고생이 많아요!!!"));
		c.toStr("화이팅!!!");
		
	}

	
}
