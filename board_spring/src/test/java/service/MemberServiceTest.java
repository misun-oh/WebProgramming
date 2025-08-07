package service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import dev.spring.board.config.AppConfig;
import dev.spring.board.dto.MemberDto;
import dev.spring.board.service.MemberService;

@SpringJUnitConfig(AppConfig.class)
public class MemberServiceTest {
	
	@Autowired
	MemberService service;
	static MemberDto member;
	
	// 초기화
	//@BeforeEach
	@BeforeAll
	public static void init(){
		member = new MemberDto();
		member.setUser_id(100+"");
		member.setPassword(1234+"");
	}
	
	@Test
	public void login() {
		// model객체 수동 생성
		Model model = new ExtendedModelMap();
		boolean res = service.login(model, member);
		
		assertTrue(res);
	}
	
}














