package com.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// 매개변수 있는 생성자
@AllArgsConstructor
// 기본생성자
@NoArgsConstructor
public class MemberVO {
	private String id;
	private String pw;
	private String name;
	// 관리자인지 아닌지 판단 하는 값이므로 boolean타입으로 설정
	private boolean adminYN;
}
