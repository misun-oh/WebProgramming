package com.chap3.map;

public class Page {
	// 기본값 설정
	int pageNo = 1;
	int startNo = 1;
	int endNo = 10;
	
	public Page() {
	}
	
	public Page(int pageNo) {
		this.pageNo = pageNo;
		// 페이지 번호 이용해서 시작번호와 끝번호를 구한다
		endNo = pageNo*10;
		startNo = endNo -9;
	}
	
	public Page(int startNo, int endNo) {
		super();
		this.startNo = startNo;
		this.endNo = endNo;
	}

	@Override
	public String toString() {
		String str = "";
		for(int i=startNo;i<=endNo;i++) {
			// 기존에 값을 유지
			str += i + " ";
			// str = str + i + " ";
		}
		return str;
	}
}
