package dev.spring.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	
	
	private int age;
	private String id       ;
	private String pass     ;
	private String name     ;
	private String regidate ;
	
	
	
	
	
	
	
	
	
	
	private String user_id               ;
	
	
	
	
	private String username              ;
	private String password              ;
	private String email                 ;
	private String phone_number          ;
	private String profile_image_url     ;
	private String created_at            ;
	private String last_login_at         ;
	private int login_fail_count      	 ;
	private String account_locked        ;
	private String[] roles                ;
                                         
}
