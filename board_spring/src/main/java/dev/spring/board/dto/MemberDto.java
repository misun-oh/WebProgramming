package dev.spring.board.dto;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {               
	private String user_id             ;
	private String username            ;
	private String password            ;
	private String email               ;
	private String phone_number        ;
	private String profile_image_url   ;
	private String created_at          ;
	private String last_login_at       ;
	private int login_fail_count       ;
	private String account_locked      ;
	private String[] roles             ;
	
	// 권한이 있는지 확인하는 메서드
	public boolean hasRole(String role) {
		System.out.println("role : " + role);
		System.out.println("roles : " + Arrays.toString(roles));
		return Arrays.asList(roles).contains(role);
	}
                                       
}
