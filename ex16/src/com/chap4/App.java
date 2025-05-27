package com.chap4;

import com.chap4.method.Overloading;
import com.chap4.method.User;

public class App {

	public static void main(String[] args) {
		Overloading ol = new Overloading();
		// 기본생성자에 의해 만들어진 뽀로로
		User pororo = new User();
		System.out.println(pororo.getAge());
		System.out.println(pororo.getName());
		System.out.println("=======================");
		ol.method5(pororo);
		User pororo1 = ol.method5(pororo);
		System.out.println(pororo.getAge());
		System.out.println(pororo.getName());
		System.out.println("========================");
		System.out.println(pororo1.getAge());
		System.out.println(pororo1.getName());
		if(pororo == pororo1) {
			System.out.println("같은객체");
		} else {
			System.out.println("다른객체");
		}
		
		
		System.out.println("================");
		System.out.println("... 가변인자 매개변수");
		ol.method6(new int[]{1,2,3,4,5,6});
		ol.method7("김형경", 1,2,3,4,5,6);
		
	}

}
