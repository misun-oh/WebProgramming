package com.chap3.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chap3.map.vo.Snack;

public class B_HashMap {
	public static void main(String[] args) {
		B_HashMap b = new B_HashMap();
		b.method2();
	}
	private void method2() {
		Map<String, Object> returnMap = method1();
		// Object o = returnMap.get("list");
		List<Snack> list =  (List<Snack>)returnMap.get("list");
		System.out.println(list);
		
		System.out.println(returnMap.get("s1"));
		System.out.println(returnMap.get("s2"));
		System.out.println(returnMap.get("s3"));
		

	}
	
	private Map<String, Object> method1() {
		
		// Map 생성
		// 과자 3개 담기
		// 만약 map에 여러가지 타입을 담고 싶으면 Value의 타입을 Object로 주어야 한다!
		// 제넥릭을 이용해서 강제로 타입을 지정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("s1", new Snack("초코맛", 1000));
		map.put("s2", new Snack("바나나맛", 1000));
		map.put("s3", new Snack("딸기맛", 1000));
		
		List<Snack> list = new ArrayList<Snack>();
		// 키값으로 value객체를 꺼내서 담기
		list.add((Snack)map.get("s1"));
		list.add((Snack)map.get("s2"));
		list.add((Snack)map.get("s3"));
		
		map.put("list", list);
		
		return map;
		
		// 리스트생성후 과자 3개를 담기
		// 리스트를 Map에 담기

		// Map에서 과자를 꺼내서 출력 하기 * 3
		// Map에서 과자 리스트를 꺼내서 출력 하기
		
		// Map에서 과자 리스트 삭제 하기 p685
		// Map에 들어있는 요소의 갯수 확인하기
		
		
		
		
		
		
		
		
	}
}
