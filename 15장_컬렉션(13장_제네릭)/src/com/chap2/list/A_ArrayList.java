package com.chap2.list;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * 컬렉션 프레임 워크 15장 P643
 * 	자바에서 데이터를 효율적으로 저장, 검색, 수정, 삭제할 수 있도록 도와주는 클래스들의 집합
 *  배열의 한계를 극복하기위해 등장
 *  	- 고정된 크기
 *  	- 삽입/삭제의 비효율(중간요소 삽입,삭제)
 *  	- 타입의 제약 
 */
public class A_ArrayList {
	/*
	 * ArrayList
	 *   - ArrayList를 생성하면 내부적으로 10개의 객체를 저장할 수 있는 공간이 생성된다.
	 *   - 저장 순서가 유지되고 인덱스를 통해서 관리된다.
	 *   - 객체만 저장할 수 있고 null도 저장이 가능하다.
	 *   - 중복되는 객체의 저장도 허용한다.
	 *   - 제한 없이 객체를 추가 할 수 있다.
	 * 
	 */
	public void method1() {
		// object 타입 
		List list = new ArrayList();
		
		// list의 맨 마지막에 요소를 추가
		list.add("안녕!");
		list.add(1.12);
		list.add(LocalDateTime.now());
		list.add(1); // 기본타입 -> wrapperclass(Integer)로 변환 되어서 들어간다! 
		list.add(new Member());
		
		// 원하는 위치에(index) 요소를 추가
		list.add(0, new Member());
		
		// index에 해당하는 요소를 삭제하고 해당 요소를 반환
		Object oo = list.remove(0);
		
		
		System.out.println("삭제된 요소 : " + oo);
		
		System.out.println("list : " + list);
		System.out.println("list.size() : " + list.size());
		System.out.println("list.get(0) : " + list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		System.out.println("반복문을 이용한 출력 ================");
		
		for(Object o:list) {			
			// toString 메서드가 재정의되어 있는경우, 자식의 재정의된 메서드가 호출 된다
			System.out.println(o);
		}
		
		// 저장된 객체를 모두 삭제
		list.clear();
		System.out.println("list : " + list);
		
	}
	
	public void method2() {
		// 강제로 타입을 지정 -> 형변환 없이 사용 할 수 있다
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("뽀로로"));
		list.set(0, new Member("크롱"));
		list.add(new Member("루피"));
		
		// 인덱스를 이용한 삭제
		// 0번째 요소를 반환 = Member
		Member clon = list.remove(0);
		System.out.println(clon);
		// 객체를 이용한 삭제
		boolean res = list.remove(list.get(0));
		System.out.println("res : " + res);
		if(res) {
			System.out.println("루피가 삭제");
		} else {
			System.out.println("루피 없음");
		}
		System.out.println("list : " + list);
		
		for(Member m:list) {
			// 재정의
			System.out.println(m);
		}
		
		
		
	}
}












