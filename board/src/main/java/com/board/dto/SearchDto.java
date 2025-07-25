package com.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchDto {
	
	// 페이징 처리를 위해 필요한 정보 
	// 리스트 페이지를 조회 하기 위해 쿼리 실행시 필요한 정보
	private int pageNo = 1; 	// 요청 페이지 번호
	private int amount = 10; 	// 페이지당 게시물 수
	
	// 검색에 필요한 정보
	private String searchField;	// 검색필드
	private String searchWord;	// 검색어
	
	public SearchDto(String pageNo, String amount){
		
		try {
			
			if (pageNo != null)
				this.pageNo = Integer.parseInt(pageNo);
			if(amount != null)
				this.amount = Integer.parseInt(amount);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error ==== 페이지번호, 페이지당 게시물수를 세팅중 예외가 발생 하였습니다. [형변환 오류]");
		}
	}
	
}
