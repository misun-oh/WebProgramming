package com.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

	private int    id           ;
	private String pw           ;
	private String name         ;
	private String admin_yn     ;
	private String reg_date     ;
	private String grade_code   ;
	private String del_yn       ;

	
}
