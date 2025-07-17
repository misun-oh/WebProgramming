// 자바빈즈(Java Beans) 
// 데이터를저장하거나전송하는데쓰이는객체로, 
// 다른로직없이순수하게데이터만을담고 있으며, 값 객체(Value Object)라고도 함

// 1. 패키지를 지정한다
package com.jsp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data					// getter, setter, toString 생성
@AllArgsConstructor		// 모든 필드의 값을 받는 생성자
@NoArgsConstructor		// 기본생성자
public class Person {
	// 2. 필드의 접근제한자는 private
	private String name;
	private int age;

	// 3. 기본생성자
	// 4. setter, getter메서드는 public으로
}
