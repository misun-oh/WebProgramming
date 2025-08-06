package dev.spring_prj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchDto {
	// 값을 초기화 시켜주면 null처리를 생략 할수 있다
	// 필드의 경우 값을 초기화 하지 않은 경우
	// int = 0, String = null
	// 지역변수 = 초기화 하지 않으면 사용할 수 없다
    private int pageNo = 1;           // 현재 페이지
    private int amount = 10;           // 페이지 당 데이터 수
    private String searchField = "";   // 검색 필드 (ex. "title/content")
    private String searchWord = "";    // 검색어

    // getter, setter
}