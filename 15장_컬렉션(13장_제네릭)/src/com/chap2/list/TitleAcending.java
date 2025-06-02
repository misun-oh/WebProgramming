package com.chap2.list;

import java.util.Comparator;

import com.chap2.list.vo.MusicVO;

public class TitleAcending implements Comparator<MusicVO>{

	@Override
	public int compare(MusicVO o1, MusicVO o2) {
		// TODO Auto-generated method stub
		return o1.getTitle().compareTo(o2.getTitle()); 	// 오름차순
		//return o2.getTitle().compareTo(o1.getTitle());		// 내림차순
	}

}
