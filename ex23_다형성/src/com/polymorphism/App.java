package com.polymorphism;

import com.polymorphism.practice.Avante;
import com.polymorphism.practice.Car;
import com.polymorphism.practice.Grandure;
import com.polymorphism.practice.Morning;
import com.polymorphism.practice.Sonata;
import com.polymorphism.practice.Spark;

/*
 * 다형성
 *   - 부모 타입으로부터 파생된 여러 가지 자식 객체를 부모 클래스의 참조변수로 다룰 수 있는 기술이다.
 *   - 즉, 부모 클래스의 참조변수로 다양한 자식 객체를 가질 수 있다.
 *   - 상속과 인터페이스를 통해서 다형성을 구현 할 수 있다
 *   
 * UpCasing
 *  - 자식 타입 -> 부모 타입으로 형변환이 가능하다.
 *  - 형변환 연산자 생략이 가능하다. (자동 형변환)
 *  - 자식 타입의 멤버(필드, 메소드)에는 접근할 수 없다.
 * 
 * DownCasting
 *   - 부모 타입 -> 자식 타입으로 형변환이 가능하다.
 *   - 형변환 연산자 생략이 불가능하다. (명시적 형변환)
 *   - ((자식타입)부모참조변수).자식메소드();
 */
public class App {
	
	public static void main(String[] args) {
		// 추상 클래스로 선언 하면 더이상 생성 할 수 없다!
		// Car car = new Car();
		
		// 타입으로 사용 할수 있다!
		// 추상 클래스로 객체를 생성할 수 없지만 참조형 변수의 타입으로는 사용 가능하다.
		Car car = new Avante();
		
		Car[] carArr = new Car[5]; 
		carArr[0] = new Sonata();
		carArr[1] = new Avante();
		carArr[2] = new Grandure();
		carArr[3] = new Spark();
		carArr[4] = new Morning();
		

		Car car_sonata = carArr[0];
		// 오버라이딩된 메서드를 호출 했을때
		// 자식이 재정의한 메서드를 확인 할 수 있다
		System.out.println(car_sonata);
		
		// 다운캐스팅
		Sonata sonata1= (Sonata)car_sonata;
		System.out.println(sonata1.price);
		System.out.println(sonata1.getPrice());
		
		// 본의의 원래 타입으로만 형변환 가능하다
		// Avante avante = (Avante)sonata;
		
		// instanceof : 변환 가능한 타입인 경우 true를 반환 한다
		// p322 객체의 타입환인
		// 변수를 적어주면 형변환 하여 변수에 넣어준다
		if(carArr[1] instanceof Avante a){
			// 다운캐스팅 - 명시적 형변환 - 강제 형변환
			System.out.println((Avante)carArr[1]);
			System.out.println(a);
		} else {
			System.out.println("형변환이 불가능 합니다.");
		}
		
	}

}
