package com.login.service;

import java.util.Base64;

import com.login.dao.MemberDao;
import com.login.dto.MemberDto;

public class MemberService {
	MemberDao dao = new MemberDao();
	
	public MemberDto login(int id, String pw) {
		// 문자열을 암호화 해서 반환
		String encoded_pw = Base64.getEncoder().encodeToString(pw.getBytes());
		// 비밀번호를 암호화 하여 비교
		MemberDto member = dao.login(id, encoded_pw);
		return member;
	}
	
	// 테스트
	public static void main(String[] args) {
		String text = "1234";
		// 1. 문자열을 바이트 배열로 변환한 후 Base64로 인코딩 => 암호화
        String encoded = Base64.getEncoder().encodeToString(text.getBytes());
        System.out.println("인코딩 결과: " + encoded);

        // 2. Base64 문자열을 다시 바이트 배열로 디코딩 => 복호화
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);

        // 3. 디코딩된 바이트 배열을 문자열로 변환
        String decoded = new String(decodedBytes);
        System.out.println("디코딩 결과: " + decoded);
	}
}
