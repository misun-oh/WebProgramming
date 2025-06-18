package com.lib.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
	private String book_no         ;
	private String publisher_code  ;
	private String category_code   ;
	private String title           ;
	private String sub_title       ;
	private String author          ;
	private int    published_year  ;
	private String url             ;
	private String info            ;
	private String main_category   ;
	private String publisher       ;
	
	
	public BookVO(String book_no, String publisher_code, String category_code, String title, String author,
			String main_category, String publisher) {
		super();
		this.book_no = book_no;
		this.publisher_code = publisher_code;
		this.category_code = category_code;
		this.title = title;
		this.author = author;
		this.main_category = main_category;
		this.publisher = publisher;
	}
	
	
}
