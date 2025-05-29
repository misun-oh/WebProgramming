package com.practice;

import com.practice.model.vo.Animal;
import com.practice.model.vo.Cat;
import com.practice.model.vo.Dog;

public class App {
	public static void main(String[] args) {
		// Animal 타입의 객체배열 크기 5로 생성 
		Animal[] animal = new Animal[5];
		
		// 각 인덱스에 무작위로 Dog객체 또는 Cat객체로 생성
		// (매개변수 생성자를 이용하여 생성)
		animal[0] = new Cat("나비", "페르시안", "서울", "흰색");
		animal[1] = new Dog("뽀삐", "말티즈", 5);
		animal[2] = new Cat("블랙캣", "러시안블루", "집", "회색");
		animal[3] = new Dog("서태지", "챠우챠우", 30);
		animal[4] = new Dog("큰개", "시베리안허스키", 20);
		
		for(int i=0;i<animal.length;i++) {
			// 무작위수 추출
			// 0.0000001~0.999999
			int num = (int)(Math.random()*10)+1;
			// 짝수이면 고양이, 홀수이면 강아지
			if(num%2 == 0) {
				animal[i] = new Cat("나비", "페르시안", "서울", "흰색");
			} else {
				animal[i] = new Dog("서태지", "챠우챠우", 30);
			}
			
		}
		
		
		
		
		// 반복문을 통해서 해당 배열의 0번 인덱스부터 마지막 인덱스까지의 
		// 객체의 speak() 메소드 호출
		for(Animal a : animal) {
			// 자식의 오버라이딩된 메서드가 호출!!
			a.speak();
		}

	}
}
