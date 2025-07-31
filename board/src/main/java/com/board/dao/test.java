package com.board.dao;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		// 검색필드에 여러개의 컬럼이 사용되는 경우
		String searchField = "title/content";
		// 검색어
		String searchWord = "제목";
		
		String where = "" ;
		// /로 끊어서 문자 배열을 반환
		String[] searchFieldArr = searchField.split("/");
		for(int i=0;i<searchFieldArr.length;i++) {
			where += searchFieldArr[i] + " like '%" + searchWord + "%' ";
			if(i != searchFieldArr.length-1) {
				// 마지막요소에는 or 를 붙이고 싶지 않음
				where += " or ";
			}
		}
		
		where = "and (" + where + ")"; 
		// 패키지명을 포함한 클래스명 + 주소 
		System.out.println(where);
		// 데이터 출력
		System.out.println(Arrays.toString(searchFieldArr));
		
		
		
		
	}
}
