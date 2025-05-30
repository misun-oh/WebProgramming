package com.chap1;

import com.chap1.generic.Box;

public class App {
	public static void main(String[] args) {
		Box boxS = new Box();
		boxS.setContent("방가방가");

		// 강제형변환 = 예외발생 가능성이 있음
		String str = (String)boxS.getContent();
		// 약한타입체크 - 강제성이 없다 - 실행시 예외가 발생 할 수 있다
		int ii = (int)boxS.getContent();
		
		Box boxI = new Box();
		boxI.setContent(1);
		
		int i=(int)boxI.getContent();
		
		int num=(int)boxS.getContent();
	}
	
	
}
