package com.chap3;

import com.chap3.field.StaticField;

public class App {

	public static void main(String[] args) {
		// 객체를 생성하지 않고 클래스이름으로 접근이 가능 하다
		System.out.println(StaticField.pubSta);
		// 접근제한자의 영향을 받는다
		// private 선언시 패키지가 다른경우 접근이 불가능 하다		
		StaticField.setPubSta("setPubSta");
		System.out.println(StaticField.pubSta);
		
	}

}
