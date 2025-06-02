package com.chap3.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chap3.map.vo.Snack;

public class C_HashMap {
	
	public static void main(String[] args) {
		C_HashMap c = new C_HashMap();
		//c.printMap();
		c.method();
	}
	
	private void method() {
		Map<String, Object> m = getMap();
		Set<String> keySet = m.keySet();
		
		Iterator<String> i = keySet.iterator(); // 반복자
		// 다음이 있니?
		while(i.hasNext()) {
			// 가지고 와
			String key = i.next();
			Object o = m.get(key);
			System.out.println(key);
			System.out.println(o);
		}
		
		// 사용한 것을 재사용이 불가능 하다!
		while(i.hasNext()) {
			System.out.println("사용이 불가능!");
		}
	}
	/*
	 * Map의 요소를 출력
	 */
	private void printMap() {
		// method1을 호출 하고 반환된 map에 들어 있는 리스트와 페이지 정보를 출력 
		Map<String, Object> m = getMap();
		
		System.out.println("요소의 갯수 : " + m.size());
		System.out.println("list, page");
		System.out.println("==========================");
		// 키 값에 해당 하는 요소를 삭제하고 반환 한다.
		Object o = m.remove("list");
		System.out.println("삭제된 오브젝트 : " + o);
		// 삭제되서 없는 키값이 요청 되면 null을 반환
		//List<Snack> list = (List<Snack>) m.get("list");
		List<Snack> list = (List<Snack>) o;
		//System.out.println(list);
		for(Snack s:list) {
			System.out.println(s.getFlavor() + "\t" + s.getCalorie());
		}
		
		Page p = (Page) m.get("page");
		System.out.println(p);
	}
	
	/*
	 * Map객체를 생성하고 과자목록과 페이지 정보를 저장
	 * Map을 생성 해서 Map을 반환 
	 * 
	 * 
	 */
	private Map<String, Object> getMap() {
		
		// 3개의 과자가 들어있는 과자목록을 만들기 - 5분
		// 리스트를 생성하고 과자를 3개 넣으세요
		List<Snack> list = new ArrayList<Snack>();
		// 나중에는 데이터베이스에서 데이터를 조회 해서 객체를 생성
		list.add(new Snack("초코맛", 1000));
		list.add(new Snack("딸기맛", 1500));
		list.add(new Snack("바닐라맛", 2000));
		
		// 페이지 정보를 저장할 페이지 객체 만들기 (31-40)
		Page page = new Page(4);
		
		// Map을 생성하고 과자목록과 페이지 정보를 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("page", page);
		
		return map;
		
	}
	
}
