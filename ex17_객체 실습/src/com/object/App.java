package com.object;

import com.object.practice.Product;

public class App {
	public static void main(String[] args) {
		// 매개변수 생성자를 이용하여 4개의 객체 생성 (위의 사용데이터 참고)
		// 객체가 가진 필드 값 출력 확인
		Product p1 = new Product("ss", "note10","수원","갤럭시 노트 10", 960000,0.1);
		Product p2 = new Product("ss", "s25","평택","갤럭시 s25", 1200000,0.7);
		Product p3 = new Product("apple", "iphone14","강남","아이폰 15", 1400000,0.3);
		Product p4 = new Product("apple", "iphone15","태평로","아이폰 14", 1200000,0.5);
		
		System.out.println(p1.information());
		System.out.println(p2.information());
		System.out.println(p3.information());
		System.out.println(p4.information());
		
		// 각 객체의 가격을 모두 120만원으로 변경 / 부가세율도 모두 0.1로 변경
		// 객체가 가진 필드 값 출력 확인
//		p1.setPrice(1200000);
//		p1.setTax(0.1);
//
//		p2.setPrice(1200000);
//		p2.setTax(0.1);
//		
//		p3.setPrice(1200000);
//		p3.setTax(0.1);
//		
//		p4.setPrice(1200000);
//		p4.setTax(0.1);
		
		// 배열에 담아서 반복문을 이용하여 일괄적으로 변경
		//Product[] products = new Product[5];
		// products[0] = p1;
		Product[] products = {p1, p2, p3, p4, null};
		// i = 배열에 접근 하기 위한 방 번호
		for(int i=0; i<products.length; i++) {
			if(products[i] != null) {
				products[i].setPrice(1200000);
				products[i].setTax(0.1);				
			}
		}
		System.out.println("========================");
		for(Product product : products) { 
			if(product != null) {
				System.out.println(product.information());
			}
		}
		System.out.println("=======================");
		// 3. getter 메소드를 이용하여 각 객체의 가격에 부가세율을 적용한 실제 가격을 계산해서 출력
		// 부가세 포함 가격 = 가격 + (가격 * 부가세율)
		for(Product p : products) {
			if(p != null) {
				System.out.println("상품명 : " + p.getName());
				System.out.println("부가세 포함 가격 : " + p.getTaxPrice());
			}
		}
		
	}
}
