package com.kh.inherit;

import com.kh.inherit.after.Desktop;
import com.kh.inherit.after.Product;
import com.kh.inherit.after.SmartPhone;
import com.kh.inherit.after.Tv;

public class App {

	/*
	 * java 프로그램에서 유틸리티을 만들때 static이 사용된다고 하던데 유틸리티가 뭐야?
	 */
	public static void main(String[] args) {
		System.out.println("===========  new Desktop(); 기본 생성자 호출");
		Desktop dt = new Desktop();
		System.out.println(dt.information());

		System.out.println("===========  new Desktop(null, null, null, 0); 매개변수 있는 생성자 호출");
		Desktop dt1 = new Desktop("삼성", "s-25", "s25", 1500000);
		System.out.println(dt1.information());

		System.out.println("=========== toString()   // 재정의 하기 전");
		// 부모 객체도 생성이 가능 하다!!
		Product p = new Product();
		System.out.println("Product : " + p.toString());
		// 메인메서드가 모두 실행 되어지면 프로그램이 종료
		System.out.println("========== toString()   // 재정의 후");
		// 생성자를 1개라도 만들면 더이상 기본 생성자는 만들어 주지 않는다
		//SmartPhone sp = new SmartPhone();
		SmartPhone sp = new SmartPhone("아이폰", "iphone15", "i15", 1500000);
		System.out.println(sp);
	
		System.out.println("========== TV" );
		Tv tv = new Tv("LG", "sm-tv", "스마트TV", 1500000, 60);
		System.out.println(tv.information());
		
		Product pp = new SmartPhone("아이폰", "iphone15", "i15", 1500000);
	}

}
