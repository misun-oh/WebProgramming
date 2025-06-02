package com.chap3.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chap2.list.vo.MusicVO;

public class A_HashMap {
	public void method1() {
		// key 값은 중복되지 않음 - 같은 key값으로 put할 경우 기존값 덮어쓰기
		// value 값은 중복 가능
		// 저장 순서 유지 안됨
		
		// Map 생성 
		// key의 타입과 value의 타입을 지정
		Map<String, MusicVO> map = new HashMap<String, MusicVO>();
		
		// 데이터 추가 - key, value
		map.put("m1", new MusicVO("신호등", 1));
		map.put("m1", new MusicVO("신호등...", 1));
		
		// 키의 값을 반환 
		MusicVO vo = map.get("m1");
		System.out.println(vo);
		 
	}
	
	/*
	 * map에 리스트를 담아보자!
	 */
	public void method2() {
		List<MusicVO> list = new ArrayList<MusicVO>();
		list.add(new MusicVO("아파트", 2));
		list.add(new MusicVO("너에게닿기를", 3));
		list.add(new MusicVO("like Jennie", 1));
		list.add(new MusicVO("신호등", 5));
		
		Page p = new Page();
		System.out.println(p);
//		p=new Page(5);
//		System.out.println(p);
		
		
	}
}











