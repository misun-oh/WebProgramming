package com.service;

import java.util.ArrayList;
import java.util.List;

import com.service.practice.Member;
import com.service.practice.MemberService;
import com.service.practice.MemberServiceImpl;

public class App {
	public static void main(String[] args) {
		// 인터페이스는 생성 할 수가 없으므로 implements (구현체)를 통해서 생성 할수 있다
		MemberService service = new MemberServiceImpl();
		service.delete();
		
		int[] numbers = new int[5];
		
		// <Member> Generic : 리스트 내부에서 사용할 타입을 외부에서 지정
		List<Member> list = new ArrayList<>();
		ArrayList<Member> list1 = new ArrayList<>();
		
		Member m = new Member();
		list.add(m);
	}

}
