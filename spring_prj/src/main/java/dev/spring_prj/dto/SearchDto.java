package dev.spring_prj.dto;

import lombok.Data;

@Data
public class SearchDto {
    private int pageNo=1;           // 현재 페이지
    private int amount=10;           // 페이지 당 데이터 수
    private String searchField="";   // 검색 필드 (ex. "title/content")
    private String searchWord="";    // 검색어

    // getter, setter
}