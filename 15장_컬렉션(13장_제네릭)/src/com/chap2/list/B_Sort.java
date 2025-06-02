package com.chap2.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.chap2.list.vo.MusicVO;

public class B_Sort {
	public void method1() {

		/*
		 * 숫자 : 숫자의 크기순
		 * 문자 : 유니코드
		 */
		List<Integer> intItems = Arrays.asList(100,2,10,1);
		System.out.println("숫자 정렬 전=============");
		System.out.println(intItems);
		/*
		 * 반환타입 없는경우는 원본을 수정하는 경우가 많이 있다
		 */
		Collections.sort(intItems);
		System.out.println("숫자 정렬 후=============");
		System.out.println(intItems);
		
		List<String> strItems = Arrays.asList("한글", "오늘도 화이팅", "A", "a");
		System.out.println("정렬전 : " + strItems);
		Collections.sort(strItems);
		System.out.println("정렬후 : " + strItems);
		
		List<MusicVO> musicList = new ArrayList<MusicVO>();
		
		musicList.add(new MusicVO("Ice cream", 5));
		musicList.add(new MusicVO("눈의꽃", 3));
		musicList.add(new MusicVO("Butter", 2));
		musicList.add(new MusicVO("신호등", 1));
		
		/*
		 * P674
		 * Comparable : 클래스 자체에 정렬 기준을 넣고 싶을때
		 * Comparator : 클래스 외부에서 정렬 기준을 정의 하고 싶을때
		 */
		Collections.sort(musicList);
		System.out.println(musicList);
		
		System.out.println("==== 타이틀로 비교하기");
		Collections.sort(musicList, new TitleAcending());
		System.out.println(musicList);
		
		
		Collections.sort(musicList, (o1, o2) 
										-> o1.getTitle().compareTo(o2.getTitle()));
		
		Collections.sort(musicList, new Comparator<MusicVO>() {

			@Override
			public int compare(MusicVO o1, MusicVO o2) {
				// TODO Auto-generated method stub
				return o1.getTitle().compareTo(o2.getTitle());
			}
												
		});
		
		
		
	}
}
