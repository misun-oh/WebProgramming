package com.kh.inherit;

import com.kh.inherit.after.SmartPhone;

public class SmartphoneApp {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("", "", "sp", 0);
		SmartPhone sp1 = new SmartPhone("", "", "sp", 0);
		System.out.println("========   equals 메서드");
		System.out.println(sp.equals(sp));
		// sp의 equals메서드를 호출 하면서 매개변수로 sp1을 넣어줌
		// 통신사와 상품명이 같으면 두 객체가 같다고 판단
		System.out.println(sp.equals(sp1));
		
		
		
	}
}
