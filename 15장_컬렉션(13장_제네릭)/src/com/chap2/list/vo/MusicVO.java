package com.chap2.list.vo;

public class MusicVO implements Comparable<MusicVO>{
	private String title;
	private int ranking;
	
	public MusicVO(String title, int ranking) {
		super();
		this.title = title;
		this.ranking = ranking;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return title + "/" + ranking;
	}
	/*
	 * 반환값에 따라서 정렬 기준이 결정
	 * 
	 * 음수, 0 -> 자리 바꾸지 않음
	 * 양수 : 자리바꿈 -> 오름차순 정렬
	 * 
	 */
	@Override
	public int compareTo(MusicVO o) {
		//return ranking - o.ranking; 	// 오름차순 정렬
		return o.ranking - ranking;		// 내림차순 정렬
	}

}
