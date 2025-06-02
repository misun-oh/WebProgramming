package com.chap2.list;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class C_Ramda {
	public static void main(String[] args) {
		method1();
	}
	public static void method1() {
		// 메서드를 변수에 저장한다고?!
		// 정수를 매개변수로 전달 받아서 10을 더해서 반환
		// (매개변수) -> 코드구현
		
		// 인터페이스에 미구현된 메서드가 1개인 경우
		// Function인터페이스의 미구현된 메서드를 구현 (= 메서드를 변수에 저장)
		// 추상메서드를 가지고 있으면 생성할 수 없다
		// 코드블럭을 생략할 경우, return 문도 생략 할 수 있다
		// 매개변수가 하나인 경우 괄호()를 생략 할 수 있다
		Function<Integer, Integer> f = x -> x+10;

		Function<Integer, Integer> ff = new FF();
		ff.apply(1);
		
		// 익명의 클래스를 이용하는 방법
		Function<Integer, Integer> fff = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		fff.apply(1);
		
		System.out.println(f.apply(1));
		
		Function<String, Integer> s = (x) -> x.length();
		System.out.println(s.apply("오늘은 월요일!"));
		
		Predicate<Integer> p = (x) -> x>10;
		System.out.println(p.test(11));
		
		// Consumer는 반환타입이 없는데 반환을 하면 오류가 발생 할 수 있다
		//Consumer<String> c = (x) -> x;
		Consumer<String> c = (x) -> System.out.println(x);
		Consumer<String> c1 = (x) -> {
										System.out.println(x.length());
									};
									
		c.accept("test");

		// 반환타입의 유무, 리턴타입의 유무에 따라서 인터페이스를 정의 하고 
		// 추상메서드를 하나 생성 해놓으면 람다식을 활용 하여 메서드를 변수에 저장하거나 메서드를 매개변수로 넘겨줄 수 있다
		// 변수에 메서드를 대입
		Supplier<String> s1 = ()-> "Hello";
		System.out.println(s1.get());
		
		
	}
}
